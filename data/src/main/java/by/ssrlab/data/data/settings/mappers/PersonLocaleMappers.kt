package by.ssrlab.data.data.settings.mappers

import by.ssrlab.data.data.mappers.toLanguage
import by.ssrlab.data.data.mappers.toLanguageEntity
import by.ssrlab.data.data.mappers.toPerson
import by.ssrlab.data.data.mappers.toPersonEntity
import by.ssrlab.data.data.settings.locale.PersonLocaleEntity
import by.ssrlab.data.data.settings.remote.PersonLocale

fun PersonLocale.toPersonLocaleEntity() = PersonLocaleEntity(
        pk = pk,
        description = description.toPersonEntity(),
        language = language.toLanguageEntity(),
        about = about,
        audio = audio,
        name = name
    )

fun PersonLocaleEntity.toPersonLocale() = PersonLocale(
        pk = pk,
        description = description.toPerson(),
        language = language.toLanguage(),
        about = about,
        audio = audio,
        name = name
    )