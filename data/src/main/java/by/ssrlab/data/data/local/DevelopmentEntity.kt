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
        parentColumn = "organizationPk",
        entity = OrganizationEntity::class,
        entityColumn = "pk"
    )
    val organization: OrganizationEntity,

    @Relation(
        parentColumn = "departmentFilterPk",
        entity = DepartmentFilterEntity::class,
        entityColumn = "pk"
    )
    val departmentFilter: DepartmentFilterEntity,

    @Embedded
    val image: ImageEntity
)
