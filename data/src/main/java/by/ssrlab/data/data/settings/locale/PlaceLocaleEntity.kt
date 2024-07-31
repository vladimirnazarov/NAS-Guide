package by.ssrlab.data.data.settings.locale

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import by.ssrlab.data.data.local.LanguageEntity
import by.ssrlab.data.data.local.PlaceEntity

@Entity
data class PlaceLocaleEntity(
    @PrimaryKey
    val pk: Int,

    @Relation(
        parentColumn = "placeEntityPk",
        entity = PlaceEntity::class,
        entityColumn = "pk"
    )
    val description: PlaceEntity,

    @Embedded(prefix = "language_")
    val language: LanguageEntity,
    val about: String,
    val audio: String,
    val name: String
)