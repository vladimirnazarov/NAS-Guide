package by.ssrlab.domain.repository.network

import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface AudioApiService {

    @GET
//        ("exhibits")
    suspend fun getExhibits(): Response<List<JSONObject>>

    @GET
//        ("audio")
    suspend fun downloadAudio(@Url fileUrl: String): Response<ResponseBody>

}

