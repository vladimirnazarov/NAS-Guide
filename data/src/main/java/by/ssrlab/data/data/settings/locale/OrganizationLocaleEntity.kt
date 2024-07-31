package by.ssrlab.data.data.settings.locale

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import by.ssrlab.data.data.local.LanguageEntity
import by.ssrlab.data.data.local.OrganizationEntity

@Entity
data class OrganizationLocaleEntity(
    @PrimaryKey
    val pk: Int,

    @Relation(
        parentColumn = "organizationEntityPk",
        entity = OrganizationEntity::class,
        entityColumn = "pk"
    )
    val description: OrganizationEntity,

    @Embedded(prefix = "language_")
    val language: LanguageEntity,
    val about: String,
    val audio: String?,
    val name: String,
    val contacts: String,
    val achievements: List<String>,
    val researchAreas: List<String>
)