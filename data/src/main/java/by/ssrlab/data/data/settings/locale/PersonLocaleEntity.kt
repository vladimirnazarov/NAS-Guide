package by.ssrlab.data.data.settings.locale

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import by.ssrlab.data.data.local.LanguageEntity
import by.ssrlab.data.data.local.PersonEntity

@Entity
data class PersonLocaleEntity(
    @PrimaryKey
    val pk: Int,

    @Relation(
        parentColumn = "personEntityPk",
        entity = PersonEntity::class,
        entityColumn = "pk"
    )
    val description: PersonEntity,

    @Embedded(prefix = "language_")
    val language: LanguageEntity,
    val about: String,
    val audio: String?,
    val name: String
)