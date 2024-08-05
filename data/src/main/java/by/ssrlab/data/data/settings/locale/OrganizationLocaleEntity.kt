package by.ssrlab.data.data.settings.locale

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import by.ssrlab.data.data.local.LanguageEntity
import by.ssrlab.data.data.local.OrganizationEntity

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = OrganizationEntity::class,
            parentColumns = ["pk"],
            childColumns = ["organizationEntityPk"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class OrganizationLocaleEntity(

    @PrimaryKey
    val pk: Int,

    val organizationEntityPk: Int,

    @Embedded(prefix = "language_")
    val language: LanguageEntity,
    val about: String,
    val audio: String?,
    val name: String,
    val contacts: String,
    val achievements: List<String>,
    val researchAreas: List<String>
)