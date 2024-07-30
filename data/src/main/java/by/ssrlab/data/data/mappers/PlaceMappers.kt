package by.ssrlab.data.data.mappers

import by.ssrlab.data.data.local.PlaceEntity
import by.ssrlab.data.data.remove.Place

fun Place.toPlaceEntity(existingIds: Set<Int>): PlaceEntity {
    return PlaceEntity(
        pk = pk,
        keyName = keyName,
        logo = logo,
        lat = lat,
        lon = lon,
        image = image.toImageEntity(existingIds)
    )
}

fun PlaceEntity.toPlace(): Place {
    return Place(
        pk = pk,
        keyName = keyName,
        logo = logo,
        lat = lat,
        lon = lon,
        image = image.toImage()
    )
}