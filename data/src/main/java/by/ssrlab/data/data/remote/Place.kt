package by.ssrlab.data.data.remote

import android.os.Parcelable
import by.ssrlab.data.data.common.DescriptionData
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Place(

    @SerializedName("pk")
    override val pk: Int,

    @SerializedName("key_name")
    val keyName: String,

    @SerializedName("logo")
    override val logo: String,

    @SerializedName("latitude")
    override val lat: Double,

    @SerializedName("longitude")
    override val lon: Double,

    @SerializedName("images")
    override val image: Image
): DescriptionData, Parcelable
