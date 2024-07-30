package by.ssrlab.data.data.mappers

import by.ssrlab.data.data.local.ImageEntity
import by.ssrlab.data.data.remove.Image

import kotlin.random.Random

fun Image.toImageEntity(existingIds: Set<Int>): ImageEntity {
    var newImageId: Int
    do {
        newImageId = Random.nextInt(Int.MAX_VALUE)
    } while (existingIds.contains(newImageId))

    return ImageEntity(
        id = newImageId,
        address = address
    )
}

fun ImageEntity.toImage(): Image {
    return Image(
        address = address
    )
}