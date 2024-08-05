package by.ssrlab.domain.repository.network

import by.ssrlab.data.data.common.DescriptionData
import by.ssrlab.data.data.remote.DepartmentFilter
import by.ssrlab.data.data.remote.Development
import by.ssrlab.data.data.remote.Image
import by.ssrlab.data.data.remote.Organization
import by.ssrlab.data.data.remote.Person
import by.ssrlab.data.data.remote.Place
import by.ssrlab.data.util.ExhibitObject
import by.ssrlab.domain.utils.BASE_URL
import by.ssrlab.domain.utils.CACHE_SIZE
import by.ssrlab.domain.utils.REQUEST_TIME_OUT
import by.ssrlab.domain.utils.fromJson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.FileOutputStream
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    fun getInstance(): Retrofit {
//        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        //if needed

        val client = OkHttpClient.Builder()
            .connectTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
            .callTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
//            .addInterceptor(interceptor as HttpLoggingInterceptor)
            .retryOnConnectionFailure(true)
            .followRedirects(false)
            .cache(Cache(File(context.cacheDir, "api_audio_cache"), CACHE_SIZE))
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}


object ExhibitAudioClient {
    private val retrofit = RetrofitInstance.getInstance()
    private val apiService = retrofit.create(AudioApiService::class.java)

    fun getExhibits(
        scope: CoroutineScope,
        dbDao: ExhibitDao,
        exhibitObj: ExhibitObject,
        onSuccess: () -> Unit,
        onFailure: () -> Unit
    ) {
        scope.launch {
            try {
                val response = apiService.getExhibits()
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    val arrayOfExhibits = arrayListOf<DescriptionData>()

                    responseBody?.let { jArray ->
                        for (i in jArray.indices) {
                            val jsonObject = jArray[i]
                            val exhibitObject = when (exhibitObj) {
                                ExhibitObject.Development -> {
                                    Development(
                                        pk = jsonObject.getInt("pk"),
                                        keyName = jsonObject.getString("key_name"),
                                        logo = jsonObject.getString("logo"),
                                        organization = Organization.fromJson(
                                            jsonObject.getJSONObject(
                                                "organization"
                                            )
                                        ),
                                        departmentFilter = DepartmentFilter.fromJson(
                                            jsonObject.getJSONObject("department_filter")
                                        ),
                                        image = Image.fromJson(jsonObject.getJSONObject("images")),
                                        lon = jsonObject.getDouble("lon"),
                                        lat = jsonObject.getDouble("lat")
                                    )
                                }

                                ExhibitObject.Organization -> {
                                    Organization(
                                        pk = jsonObject.getInt("pk"),
                                        keyName = jsonObject.getString("key_name"),
                                        lat = jsonObject.getDouble("latitude"),
                                        lon = jsonObject.getDouble("longitude"),
                                        logo = jsonObject.getString("logo"),
                                        departmentFilter = DepartmentFilter.fromJson(
                                            jsonObject.getJSONObject("department_filter")
                                        ),
                                        image = Image.fromJson(jsonObject.getJSONObject("images"))
                                    )
                                }

                                ExhibitObject.Person -> {
                                    Person(
                                        pk = jsonObject.getInt("pk"),
                                        keyName = jsonObject.getString("key_name"),
                                        logo = jsonObject.getString("logo"),
                                        image = Image.fromJson(jsonObject.getJSONObject("images")),
                                        lon = if (jsonObject.has("lon")) jsonObject.optDouble("lon") else null,
                                        lat = if (jsonObject.has("lat")) jsonObject.optDouble("lat") else null
                                    )
                                }

                                ExhibitObject.Place -> {
                                    Place(
                                        pk = jsonObject.getInt("pk"),
                                        keyName = jsonObject.getString("key_name"),
                                        logo = jsonObject.getString("logo"),
                                        lat = jsonObject.getDouble("latitude"),
                                        lon = jsonObject.getDouble("longitude"),
                                        image = Image.fromJson(jsonObject.getJSONObject("images"))
                                    )
                                }
                            }
                            arrayOfExhibits.add(exhibitObject)
                        }
                    }

                    val dbArray = dbDao.getAllExhibits() as ArrayList<*>

                    if (dbArray != arrayOfExhibits) {
                        dbDao.deleteExhibits()
                        activity.getExternalFilesDir(null)?.deleteRecursively()
                        for (i in arrayOfExhibits) dbDao.insert(i)
                    }

                    onSuccess()
                } else {
                    onFailure()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                onFailure()
            }
        }
    }

    fun getAudio(
        scope: CoroutineScope,
        link: String,
        file: File,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        scope.launch {
            try {
                val response = apiService.downloadAudio(link)
                if (response.isSuccessful) {
                    response.body()?.let { responseBody ->
                        withContext(Dispatchers.IO) {
                            FileOutputStream(file).use { fos ->
                                fos.write(responseBody.bytes())
                            }
                        }
                        onSuccess()
                    } ?: run {
                        onFailure("Response body is null")
                    }
                } else {
                    onFailure(
                        "Failed to download file: ${
                            response.errorBody()?.string() ?: "Unknown error"
                        }"
                    )
                }
            } catch (e: Exception) {
                onFailure(e.message ?: "An error occurred")
            }
        }
    }
}