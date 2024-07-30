package by.ssrlab.data.data.mappers

import by.ssrlab.data.data.local.ImageEntity
import by.ssrlab.data.data.remote.Image

import kotlin.random.Random

fun Image.toImageEntity(): ImageEntity {
    return ImageEntity(
        id = Random.nextInt(Int.MAX_VALUE),
        address = address
    )
}

fun ImageEntity.toImage(): Image {
    return Image(
        address = address
    )
}