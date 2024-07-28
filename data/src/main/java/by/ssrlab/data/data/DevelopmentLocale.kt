package by.ssrlab.data.data

import by.ssrlab.data.data.additional.Development
import by.ssrlab.data.data.additional.Language
import com.google.gson.annotations.SerializedName

data class DevelopmentLocale(

    @SerializedName("pk")
    val pk: Int,

    @SerializedName("development")
    val development: Development,

    @SerializedName("lang")
    val language: Language,

    @SerializedName("about")
    val about: String,

    @SerializedName("audio")
    val audio: String?,

    @SerializedName("name")
    val name: String
)