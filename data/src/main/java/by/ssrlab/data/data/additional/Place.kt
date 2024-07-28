package by.ssrlab.data.data.additional

import com.google.gson.annotations.SerializedName

data class Place(

    @SerializedName("pk")
    val pk: Int,

    @SerializedName("key_name")
    val keyName: String,

    @SerializedName("logo")
    val logo: String,

    @SerializedName("latitude")
    val lat: Double,

    @SerializedName("longitude")
    val lon: Double,

    @SerializedName("images")
    val image: Image
)
