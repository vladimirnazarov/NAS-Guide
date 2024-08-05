package by.ssrlab.data.data.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = OrganizationEntity::class,
            parentColumns = ["pk"],
            childColumns = ["organizationPk"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = DepartmentFilterEntity::class,
            parentColumns = ["pk"],
            childColumns = ["departmentFilterPk"],
            onDelete = ForeignKey.CASCADE
        ),
    ]
)
data class DevelopmentEntity(

    @PrimaryKey
    val pk: Int,
    val keyName: String,
    val logo: String,

    val organizationPk: Int,

    val departmentFilterPk: Int,

    @Embedded
    val image: ImageEntity
)
