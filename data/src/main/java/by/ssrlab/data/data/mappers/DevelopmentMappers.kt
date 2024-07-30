package by.ssrlab.data.data.mappers

import by.ssrlab.data.data.local.DevelopmentEntity
import by.ssrlab.data.data.remove.Development

fun DevelopmentEntity.toDevelopment(): Development {
   return Development(
       pk = pk,
       keyName = keyName,
       logo = logo,
       organization = organization.toOrganization(),
       departmentFilter = departmentFilter.toDepartmentFilter(),
       image = image.toImage()
   )
}

fun Development.toDevelopmentEntity(existingIds: Set<Int>): DevelopmentEntity {
    return DevelopmentEntity(
        pk = pk,
        keyName = keyName,
        logo = logo,
        organization = organization!!.toOrganizationEntity(existingIds),
        departmentFilter = departmentFilter.toDepartmentFilterEntity(),
        image = image.toImageEntity(existingIds)
    )
}