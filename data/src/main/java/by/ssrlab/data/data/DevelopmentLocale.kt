package by.ssrlab.data.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import by.ssrlab.data.data.remove.Development
import by.ssrlab.data.data.remove.Language
import by.ssrlab.data.data.common.RepositoryData
import com.google.gson.annotations.SerializedName

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
    val about: String,

    @SerializedName("audio")
    val audio: String?,

    @SerializedName("name")
    override val name: String
): RepositoryData