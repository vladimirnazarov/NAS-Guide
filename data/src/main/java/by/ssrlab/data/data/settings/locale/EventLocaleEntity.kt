package by.ssrlab.data.data.settings.locale

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import by.ssrlab.data.data.local.EventEntity
import by.ssrlab.data.data.local.LanguageEntity

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = EventEntity::class,
            parentColumns = ["pk"],
            childColumns = ["eventEntityPk"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class EventLocaleEntity(

    @PrimaryKey
    val pk: Int,

    val eventEntityPk: Int,

    @Embedded(prefix = "language_")
    val language: LanguageEntity,
    val about: String,
    val name: String,
)