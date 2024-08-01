package by.ssrlab.data.data.common

import android.os.Parcelable
import by.ssrlab.data.data.remote.Image

interface DescriptionData: Parcelable {
    val pk: Int
    val keyName: String
    val logo: String
    val image: Image
    val lon: Double?
    val lat: Double?
}