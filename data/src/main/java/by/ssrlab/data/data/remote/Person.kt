package by.ssrlab.data.data.remote

import android.os.Parcelable
import by.ssrlab.data.data.common.DescriptionData
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(

    @SerializedName("pk")
    override val pk: Int,

    @SerializedName("key_name")
    val keyName: String,

    @SerializedName("logo")
    override val logo: String,

    @SerializedName("images")
    override val image: Image,

    @Expose
    override val lon: Double? = null,

    @Expose
    override val lat: Double? = null
) : DescriptionData, Parcelable