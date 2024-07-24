package by.ssrlab.data.data

import by.ssrlab.data.data.additional.Language

data class OrganizationLocale(
    val pk: Int,
    //val organization,
    val language: Language,
    val about: String,
    val audio: String?,
    val name: String,
    val contacts: String,
    val achievements: List<String>,
    val researchAreas: List<String>
)
