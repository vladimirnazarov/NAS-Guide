package by.ssrlab.data.api

import by.ssrlab.data.data.OrganizationLocale
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//1 - en
//2 - by
//3 - ru

interface OrgsApi {

    @GET("api/rest/organizationlocales/")
    fun get(@Query("lang") language: Int): Call<List<OrganizationLocale>>
}