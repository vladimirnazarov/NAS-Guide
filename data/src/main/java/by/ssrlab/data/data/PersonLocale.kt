package by.ssrlab.data.data

import by.ssrlab.data.data.additional.Language
import by.ssrlab.data.data.additional.Person
import com.google.gson.annotations.SerializedName

data class PersonLocale(

    @SerializedName("pk")
    val pk: Int,

    @SerializedName("person")
    val person: Person,

    @SerializedName("lang")
    val language: Language,

    @SerializedName("about")
    val about: String,

    @SerializedName("audio")
    val audio: String?,

    @SerializedName("name")
    val name: String
)