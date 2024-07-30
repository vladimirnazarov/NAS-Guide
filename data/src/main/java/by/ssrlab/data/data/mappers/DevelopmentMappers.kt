package by.ssrlab.data.data.mappers

import by.ssrlab.data.data.local.DevelopmentEntity
import by.ssrlab.data.data.remote.Development

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

fun Development.toDevelopmentEntity(): DevelopmentEntity {
    return DevelopmentEntity(
        pk = pk,
        keyName = keyName,
        logo = logo,
        organization = organization!!.toOrganizationEntity(),
        departmentFilter = departmentFilter.toDepartmentFilterEntity(),
        image = image.toImageEntity()
    )
}