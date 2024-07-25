package by.ssrlab.data.data

import by.ssrlab.data.data.additional.Language
import by.ssrlab.data.data.additional.Place
import com.google.gson.annotations.SerializedName

data class PlaceLocale(

    @SerializedName("pk")
    val pk: Int,

    @SerializedName("place")
    val place: Place,

    @SerializedName("lang")
    val language: Language,

    @SerializedName("about")
    val about: String,

    @SerializedName("audio")
    val audio: String,

    @SerializedName("name")
    val name: String
)
