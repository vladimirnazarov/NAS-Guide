package by.ssrlab.data.data

import by.ssrlab.data.data.additional.Event
import by.ssrlab.data.data.additional.Language
import com.google.gson.annotations.SerializedName

data class EventLocale(

    @SerializedName("pk")
    val pk: Int,

    @SerializedName("event")
    val event: Event,

    @SerializedName("lang")
    val language: Language,

    @SerializedName("about")
    val about: String,

    @SerializedName("name")
    val name: String
)
