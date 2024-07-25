package by.ssrlab.data.data.additional

import com.google.gson.annotations.SerializedName

data class Language(

    @SerializedName("lang_key")
    val languageKey: String,

    @SerializedName("lang_name")
    val languageName: String
)