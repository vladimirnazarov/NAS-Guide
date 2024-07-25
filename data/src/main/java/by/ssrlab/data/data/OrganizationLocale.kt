package by.ssrlab.data.data

import by.ssrlab.data.data.additional.Language
import by.ssrlab.data.data.additional.Organization

data class OrganizationLocale(
    val pk: Int,
    val organization: Organization,
    val language: Language,
    val about: String,
    val audio: String?,
    val name: String,
    val contacts: String,
    val achievements: List<String>,
    val researchAreas: List<String>
)
