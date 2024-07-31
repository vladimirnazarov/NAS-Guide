package by.ssrlab.data.data.settings.mappers

import by.ssrlab.data.data.mappers.toDevelopment
import by.ssrlab.data.data.mappers.toDevelopmentEntity
import by.ssrlab.data.data.mappers.toLanguage
import by.ssrlab.data.data.mappers.toLanguageEntity
import by.ssrlab.data.data.settings.locale.DevelopmentLocaleEntity
import by.ssrlab.data.data.settings.remote.DevelopmentLocale

fun DevelopmentLocaleEntity.toDevelopmentLocale(): DevelopmentLocale =
    DevelopmentLocale(
        pk = pk,
        description = description.toDevelopment(),
        language = language.toLanguage(),
        about = about,
        audio = audio,
        name = name
    )

fun DevelopmentLocale.toDevelopmentLocaleEntity(): DevelopmentLocaleEntity =
    DevelopmentLocaleEntity(
        pk = pk,
        description = description.toDevelopmentEntity(),
        language = language.toLanguageEntity(),
        about = about,
        audio = audio,
        name = name
    )