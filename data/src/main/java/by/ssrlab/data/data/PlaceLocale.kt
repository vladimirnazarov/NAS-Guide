package by.ssrlab.data.data

import by.ssrlab.data.data.additional.Language
import by.ssrlab.data.data.additional.Place

data class PlaceLocale(
    val pk: Int,
    val place: Place,
    val language: Language,
    val about: String,
    val audio: String,
    val name: String
)
