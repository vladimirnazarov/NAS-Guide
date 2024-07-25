package by.ssrlab.data.data

import by.ssrlab.data.data.additional.Language
import by.ssrlab.data.data.additional.Person

data class PersonLocale(
    val pk: Int,
    val person: Person,
    val language: Language,
    val about: String,
    val audio: String?,
    val name: String
)