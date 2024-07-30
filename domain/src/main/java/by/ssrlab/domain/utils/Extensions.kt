package by.ssrlab.domain.utils

//Extensions to language dialog
fun String.transformLanguageToInt(): Int {
    return when (this) {
        "en" -> 1
        "be" -> 2
        "ru" -> 3
        else -> -1
    }
}

fun Int.transformIntToLanguage(): String {
    return when (this) {
        1 -> "en"
        2 -> "be"
        3 -> "ru"
        else -> "en"
    }
}