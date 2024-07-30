package by.ssrlab.data.data.mappers

import by.ssrlab.data.data.local.OrganizationEntity
import by.ssrlab.data.data.remove.Organization

fun Organization.toOrganizationEntity(existingIds: Set<Int>): OrganizationEntity {
    return OrganizationEntity(
        pk = pk,
        keyName = keyName,
        lat = lat,
        lon = lon,
        logo = logo,
        departmentFilter = departmentFilter.toDepartmentFilterEntity(),
        image = image.toImageEntity(existingIds)
    )
}

fun OrganizationEntity.toOrganization(): Organization {
    return Organization(
        pk = pk,
        keyName = keyName,
        lat = lat,
        lon = lon,
        logo = logo,
        departmentFilter = departmentFilter.toDepartmentFilter(),
        image = image.toImage()
    )
}