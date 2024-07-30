package by.ssrlab.data.data.mappers

import by.ssrlab.data.data.local.LanguageEntity
import by.ssrlab.data.data.remove.Language
import kotlin.random.Random

fun Language.toLanguageEntity(): LanguageEntity {
    return LanguageEntity(
        id = Random.nextInt(Int.MAX_VALUE),
        languageName = languageName,
        languageKey = languageKey
    )
}

fun LanguageEntity.toLanguage(): Language {
    return Language(
        languageName = languageName,
        languageKey = languageKey
    )
}