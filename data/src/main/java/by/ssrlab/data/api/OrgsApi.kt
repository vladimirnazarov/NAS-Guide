package by.ssrlab.data.api

import by.ssrlab.data.data.OrganizationLocale
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

//1 - en
//2 - by
//3 - ru

interface OrgsApi {

    @GET("api/rest/organizationlocales/?lang={lang}")
    fun get(@Path("lang") language: Int): Call<OrganizationLocale>
}