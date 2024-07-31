package by.ssrlab.data.data.settings.locale

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import by.ssrlab.data.data.local.DevelopmentEntity
import by.ssrlab.data.data.local.LanguageEntity

@Entity
data class DevelopmentLocaleEntity(
    @PrimaryKey
    val pk: Int,

    @Relation(
        parentColumn = "developmentEntityPk",
        entity = DevelopmentEntity::class,
        entityColumn = "pk"
    )
    val description: DevelopmentEntity,

    @Embedded(prefix = "language_")
    val language: LanguageEntity,
    val about: String,
    val audio: String?,
    val name: String
)
