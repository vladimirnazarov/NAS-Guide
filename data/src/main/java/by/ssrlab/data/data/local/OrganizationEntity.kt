package by.ssrlab.data.data.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class OrganizationEntity(
    @PrimaryKey
    val pk: Int,
    val keyName: String,
    val lat: Double,
    val lon: Double,
    val logo: String,

    @Relation(
        parentColumn = "departmentFilterId",
        entity = DepartmentFilterEntity::class,
        entityColumn = "id"
    )
    val departmentFilter: DepartmentFilterEntity,

    @Embedded
    val image: ImageEntity
)
