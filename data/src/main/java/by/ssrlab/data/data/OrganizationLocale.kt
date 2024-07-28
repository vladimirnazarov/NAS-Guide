package by.ssrlab.data.data

import by.ssrlab.data.data.additional.Language
import by.ssrlab.data.data.additional.Organization
import com.google.gson.annotations.SerializedName

data class OrganizationLocale(

    @SerializedName("pk")
    val pk: Int,

    @SerializedName("organization")
    val organization: Organization,

    @SerializedName("lang")
    val language: Language,

    @SerializedName("about")
    val about: String,

    @SerializedName("audio")
    val audio: String?,

    @SerializedName("name")
    val name: String,

    @SerializedName("contacts")
    val contacts: String,

    @SerializedName("achievements")
    val achievements: List<String>,

    @SerializedName("research_areas")
    val researchAreas: List<String>
)
