package by.ssrlab.data.data.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Language(

    @SerializedName("lang_key")
    val languageKey: String,

    @SerializedName("lang_name")
    val languageName: String
): Parcelable