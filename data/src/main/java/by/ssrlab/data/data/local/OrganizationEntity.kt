package by.ssrlab.data.data.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = DepartmentFilterEntity::class,
            parentColumns = ["pk"],
            childColumns = ["departmentFilterPk"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class OrganizationEntity(

    @PrimaryKey
    val pk: Int,
    val keyName: String,
    val lat: Double,
    val lon: Double,
    val logo: String,

    val departmentFilterPk: Int,

    @Embedded
    val image: ImageEntity
)
