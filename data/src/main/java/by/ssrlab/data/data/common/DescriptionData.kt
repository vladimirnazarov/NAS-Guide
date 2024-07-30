package by.ssrlab.data.data.common

import by.ssrlab.data.data.remote.Image

interface DescriptionData {
    val pk: Int
    val logo: String
    val image: Image
}