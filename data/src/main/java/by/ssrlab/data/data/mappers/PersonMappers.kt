package by.ssrlab.data.data.mappers

import by.ssrlab.data.data.remote.Person
import by.ssrlab.data.data.local.PersonEntity

fun Person.toPersonEntity(): PersonEntity {
    return PersonEntity(
        pk = pk,
        keyName = keyName,
        logo = logo,
        image = image.toImageEntity()
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