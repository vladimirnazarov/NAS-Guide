package by.ssrlab.data.data.settings.locale

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import by.ssrlab.data.data.local.LanguageEntity
import by.ssrlab.data.data.local.PlaceEntity

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = PlaceEntity::class,
            parentColumns = ["pk"],
            childColumns = ["placeEntityPk"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class PlaceLocaleEntity(

    @PrimaryKey
    val pk: Int,

    val placeEntityPk: Int,

    @Embedded(prefix = "language_")
    val language: LanguageEntity,
    val about: String,
    val audio: String?,
    val name: String
)