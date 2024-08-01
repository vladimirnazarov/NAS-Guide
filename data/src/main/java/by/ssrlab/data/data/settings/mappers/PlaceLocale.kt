package by.ssrlab.data.data.settings.mappers

import by.ssrlab.data.data.mappers.toLanguage
import by.ssrlab.data.data.mappers.toLanguageEntity
import by.ssrlab.data.data.mappers.toPlace
import by.ssrlab.data.data.mappers.toPlaceEntity
import by.ssrlab.data.data.settings.locale.PlaceLocaleEntity
import by.ssrlab.data.data.settings.remote.PlaceLocale

fun PlaceLocale.toPlaceLocaleEntity() = PlaceLocaleEntity(
    pk = pk,
    description = description.toPlaceEntity(),
    language = language.toLanguageEntity(),
    about = about,
    audio = audio,
    name = name
)

fun PlaceLocaleEntity.toPlaceLocale() = PlaceLocale(
    pk = pk,
    description = description.toPlace(),
    language = language.toLanguage(),
    about = about,
    audio = audio,
    name = name
)