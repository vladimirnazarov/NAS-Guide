package by.ssrlab.data.data.mappers

import by.ssrlab.data.data.local.OrganizationEntity
import by.ssrlab.data.data.remote.Organization

fun Organization.toOrganizationEntity(): OrganizationEntity {
    return OrganizationEntity(
        pk = pk,
        keyName = keyName,
        lat = lat,
        lon = lon,
        logo = logo,
        departmentFilter = departmentFilter.toDepartmentFilterEntity(),
        image = image.toImageEntity()
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