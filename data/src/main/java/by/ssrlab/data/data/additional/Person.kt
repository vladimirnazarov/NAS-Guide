package by.ssrlab.data.data.additional

import com.google.gson.annotations.SerializedName

data class Person(

    @SerializedName("pk")
    val pk: Int,

    @SerializedName("key_name")
    val keyName: String,

    @SerializedName("logo")
    val logo: String,

    @SerializedName("images")
    val image: Image
)
