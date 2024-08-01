package by.ssrlab.data.data.settings.remote

import android.os.Parcelable
import by.ssrlab.data.data.remote.Language
import by.ssrlab.data.data.remote.Place
import by.ssrlab.data.data.common.RepositoryData
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlaceLocale(

    @SerializedName("pk")
    override val pk: Int,

    @SerializedName("place")
    override val description: Place,

    @SerializedName("lang")
    val language: Language,

    @SerializedName("about")
    override val about: String,

    @SerializedName("audio")
    override val audio: String?,

    @SerializedName("name")
    override val name: String
): RepositoryData, Parcelable
