package by.ssrlab.data.data.settings.locale

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import by.ssrlab.data.data.local.LanguageEntity
import by.ssrlab.data.data.local.PersonEntity

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = PersonEntity::class,
            parentColumns = ["pk"],
            childColumns = ["personEntityPk"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class PersonLocaleEntity(

    @PrimaryKey
    val pk: Int,

    val personEntityPk: Int,

    @Embedded(prefix = "language_")
    val language: LanguageEntity,
    val about: String,
    val audio: String?,
    val name: String
)