package by.ssrlab.data.data.mappers

import by.ssrlab.data.data.local.PlaceEntity
import by.ssrlab.data.data.remote.Place

fun Place.toPlaceEntity(): PlaceEntity {
    return PlaceEntity(
        pk = pk,
        keyName = keyName,
        logo = logo,
        lat = lat,
        lon = lon,
        image = image.toImageEntity()
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