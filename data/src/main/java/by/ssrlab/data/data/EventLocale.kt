package by.ssrlab.data.data

import by.ssrlab.data.data.additional.Event
import by.ssrlab.data.data.additional.Language
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
    val about: String,

    @SerializedName("name")
    override val name: String,

    @Expose
    override val description: DescriptionData? = null
): RepositoryData
