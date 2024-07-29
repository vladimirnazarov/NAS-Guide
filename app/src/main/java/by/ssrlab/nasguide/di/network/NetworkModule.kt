package by.ssrlab.nasguide.di.network

import android.content.Context
import by.ssrlab.data.api.DevelopmentsApi
import by.ssrlab.data.api.EventsApi
import by.ssrlab.data.api.OrgsApi
import by.ssrlab.data.api.PersonsApi
import by.ssrlab.data.api.PlacesApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

private const val CLIENT_TIME_OUT = 30L
private const val BASE_URL = "https://nasbguide.krokam.by/"
private const val CACHE_SIZE = (1024 * 1024 * 5).toLong()

val networkModule = module {

    single<Retrofit>(named("network")) { provideRetrofit(context = get()) }

    single<DevelopmentsApi>(named("network")) { provideApi(retrofit = get(named("network"))) }

    single<EventsApi>(named("network")) { provideApi(retrofit = get(named("network"))) }

    single<OrgsApi>(named("network")) { provideApi(retrofit = get(named("network"))) }

    single<PersonsApi>(named("network")) { provideApi(retrofit = get(named("network"))) }

    single<PlacesApi>(named("network")) { provideApi(retrofit = get(named("network"))) }
}

private fun provideRetrofit(context: Context) =
    Retrofit.Builder()
        .client(provideClient(context))
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

private fun provideClient(context: Context) =
    OkHttpClient.Builder()
        .connectTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
        .writeTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
        .callTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .followRedirects(false)
        .cache(Cache(File(context.cacheDir, "api_cache"), CACHE_SIZE))
        .build()

inline fun <reified T> provideApi(retrofit: Retrofit): T = retrofit.create(T::class.java)