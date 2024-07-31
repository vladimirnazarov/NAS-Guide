package by.ssrlab.data.data.settings.remote

import by.ssrlab.data.data.remote.Language
import by.ssrlab.data.data.remote.Organization
import by.ssrlab.data.data.common.RepositoryData
import com.google.gson.annotations.SerializedName

data class OrganizationLocale(

    @SerializedName("pk")
    override val pk: Int,

    @SerializedName("organization")
    override val description: Organization,

    @SerializedName("lang")
    val language: Language,

    @SerializedName("about")
    val about: String,

    @SerializedName("audio")
    val audio: String?,

    @SerializedName("name")
    override val name: String,

    @SerializedName("contacts")
    val contacts: String,

    @SerializedName("achievements")
    val achievements: List<String>,

    @SerializedName("research_areas")
    val researchAreas: List<String>
): RepositoryData
