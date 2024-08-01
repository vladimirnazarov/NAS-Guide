package by.ssrlab.data.data.settings.remote

import by.ssrlab.data.data.remote.Event
import by.ssrlab.data.data.remote.Language
import by.ssrlab.data.data.common.DescriptionData
import by.ssrlab.data.data.common.RepositoryData
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class EventLocale(

    @SerializedName("pk")
    override val pk: Int,

    @SerializedName("event")
    val event: Event,

    @SerializedName("lang")
    val language: Language,

    @SerializedName("about")
    override val about: String,

    @SerializedName("name")
    override val name: String,

    @Expose
    override val audio: String? = null,

    @Expose
    override val description: DescriptionData? = null
): RepositoryData
