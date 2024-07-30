package by.ssrlab.data.data.mappers

import by.ssrlab.data.data.remove.Person
import by.ssrlab.data.data.local.PersonEntity

fun Person.toPersonEntity(existingIds: Set<Int>): PersonEntity {
    return PersonEntity(
        pk = pk,
        keyName = keyName,
        logo = logo,
        image = image.toImageEntity(existingIds)
    )
}

fun PersonEntity.toPerson(): Person {
    return Person(
        pk = pk,
        keyName = keyName,
        logo = logo,
        image = image.toImage()
    )
}