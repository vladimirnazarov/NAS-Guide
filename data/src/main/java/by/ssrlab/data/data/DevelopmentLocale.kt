package by.ssrlab.data.data

import by.ssrlab.data.data.additional.Development
import by.ssrlab.data.data.additional.Language

data class DevelopmentLocale(
    val pk: Int,
    val development: Development,
    val language: Language,
    val about: String,
    val audio: String?,
    val name: String
)