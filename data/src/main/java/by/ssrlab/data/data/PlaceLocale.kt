package by.ssrlab.data.data

import by.ssrlab.data.data.remove.Language
import by.ssrlab.data.data.remove.Place
import by.ssrlab.data.data.common.RepositoryData
import com.google.gson.annotations.SerializedName

data class PlaceLocale(

    @SerializedName("pk")
    override val pk: Int,

    @SerializedName("place")
    override val description: Place,

    @SerializedName("lang")
    val language: Language,

    @SerializedName("about")
    val about: String,

    @SerializedName("audio")
    val audio: String,

    @SerializedName("name")
    override val name: String
): RepositoryData
