package by.ssrlab.data.data

import by.ssrlab.data.data.additional.Event
import by.ssrlab.data.data.additional.Language

data class EventLocale(
    val pk: Int,
    val event: Event,
    val language: Language,
    val about: String,
    val name: String
)
