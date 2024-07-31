package by.ssrlab.data.data.settings.remote

import by.ssrlab.data.data.common.RepositoryData
import by.ssrlab.data.data.remote.Development
import by.ssrlab.data.data.remote.Language
import com.google.gson.annotations.SerializedName

data class DevelopmentLocale(
    @SerializedName("pk")
    override val pk: Int,

    @SerializedName("development")
    override val description: Development,

    @SerializedName("lang")
    val language: Language,

    @SerializedName("about")
    val about: String,

    @SerializedName("audio")
    val audio: String?,

    @SerializedName("name")
    override val name: String
) : RepositoryData