package by.ssrlab.data.data.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PersonEntity(

    @PrimaryKey
    val pk: Int,
    val keyName: String,
    val logo: String,

    @Embedded
    val image: ImageEntity
)
