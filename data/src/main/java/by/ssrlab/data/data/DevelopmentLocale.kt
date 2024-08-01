package by.ssrlab.data.data

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import by.ssrlab.data.data.remote.Development
import by.ssrlab.data.data.remote.Language
import by.ssrlab.data.data.common.RepositoryData
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class DevelopmentLocale(
    @PrimaryKey
    @SerializedName("pk")
    override val pk: Int,

    @SerializedName("development")
    override val description: Development,

    @Embedded
    @SerializedName("lang")
    val language: Language,

    @SerializedName("about")
    override val about: String,

    @SerializedName("audio")
    override val audio: String?,

    @SerializedName("name")
    override val name: String
): RepositoryData, Parcelable