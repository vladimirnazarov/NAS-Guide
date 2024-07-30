package by.ssrlab.domain.models

import android.content.Context

class SharedPreferencesUtil(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("SharedPreferencesUtil", Context.MODE_PRIVATE)

    fun getLanguage() = sharedPreferences.getString(LANGUAGE_KEY, "en")
    fun setLanguage(language: String) {
        val editor = sharedPreferences.edit()
        editor.putString(LANGUAGE_KEY, language)
        editor.apply()
    }

    companion object {
        const val LANGUAGE_KEY = "language"
    }
}