package by.ssrlab.data.data.settings.locale

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import by.ssrlab.data.data.local.DevelopmentEntity
import by.ssrlab.data.data.local.LanguageEntity

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = DevelopmentEntity::class,
            parentColumns = ["pk"],
            childColumns = ["developmentEntityPk"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class DevelopmentLocaleEntity(

    @PrimaryKey
    val pk: Int,

    val developmentEntityPk: Int,

    @Embedded(prefix = "language_")
    val language: LanguageEntity,
    val about: String,
    val audio: String?,
    val name: String
)
