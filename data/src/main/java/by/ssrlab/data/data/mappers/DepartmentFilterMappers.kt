package by.ssrlab.data.data.mappers

import by.ssrlab.data.data.local.DepartmentFilterEntity
import by.ssrlab.data.data.remote.DepartmentFilter

fun DepartmentFilter.toDepartmentFilterEntity(): DepartmentFilterEntity {
    return DepartmentFilterEntity(
        pk = pk,
        keyName = keyName
    )
}

fun DepartmentFilterEntity.toDepartmentFilter(): DepartmentFilter {
    return DepartmentFilter(
        pk = pk,
        keyName = keyName
    )
}