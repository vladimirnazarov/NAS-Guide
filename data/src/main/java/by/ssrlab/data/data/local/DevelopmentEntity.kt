package by.ssrlab.data.data.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class DevelopmentEntity(
    @PrimaryKey
    val pk: Int,
    val keyName: String,
    val logo: String,

    @Relation(
        parentColumn = "organizationId",
        entity = OrganizationEntity::class,
        entityColumn = "id"
    )
    val organization: OrganizationEntity,

    @Relation(
        parentColumn = "departmentFilterId",
        entity = DepartmentFilterEntity::class,
        entityColumn = "id"
    )
    val departmentFilter: DepartmentFilterEntity,

    @Embedded
    val image: ImageEntity
)
