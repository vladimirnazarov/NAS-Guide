package by.ssrlab.data.data.settings.locale

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import by.ssrlab.data.data.common.DescriptionData
import by.ssrlab.data.data.local.EventEntity
import by.ssrlab.data.data.local.LanguageEntity

@Entity
data class EventLocaleEntity(
    @PrimaryKey
    val pk: Int,

    @Relation(
        parentColumn = "eventEntityPk",
        entity = EventEntity::class,
        entityColumn = "pk"
    )
    val event: EventEntity,

    @Embedded(prefix = "language_")
    val language: LanguageEntity,
    val about: String,
    val name: String,

    val description: DescriptionData? = null
)