package by.ssrlab.data.data

import by.ssrlab.data.data.remote.Language
import by.ssrlab.data.data.remote.Person
import by.ssrlab.data.data.common.RepositoryData
import com.google.gson.annotations.SerializedName

data class PersonLocale(

    @SerializedName("pk")
    override val pk: Int,

    @SerializedName("person")
    override val description: Person,

    @SerializedName("lang")
    val language: Language,

    @SerializedName("about")
    val about: String,

    @SerializedName("audio")
    val audio: String?,

    @SerializedName("name")
    override val name: String
): RepositoryData