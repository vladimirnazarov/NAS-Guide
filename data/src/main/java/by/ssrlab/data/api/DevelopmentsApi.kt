package by.ssrlab.data.api

import by.ssrlab.data.data.settings.remote.DevelopmentLocale
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//1 - en
//2 - by
//3 - ru

interface DevelopmentsApi {

    @GET("api/rest/developmentlocales/")
    fun get(@Query("lang") language: Int): Call<List<DevelopmentLocale>>
}