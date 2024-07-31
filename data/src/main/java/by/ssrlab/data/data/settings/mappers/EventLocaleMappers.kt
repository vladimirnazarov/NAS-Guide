package by.ssrlab.data.data.settings.mappers

import by.ssrlab.data.data.mappers.toEvent
import by.ssrlab.data.data.mappers.toEventEntity
import by.ssrlab.data.data.mappers.toLanguage
import by.ssrlab.data.data.mappers.toLanguageEntity
import by.ssrlab.data.data.settings.locale.EventLocaleEntity
import by.ssrlab.data.data.settings.remote.EventLocale

fun EventLocale.toEventLocalEntity(): EventLocaleEntity =
    EventLocaleEntity(
        pk = pk,
        event = event.toEventEntity(),
        language = language.toLanguageEntity(),
        about = about,
        name = name,
        description = description
    )

fun EventLocaleEntity.toEventLocale(): EventLocale =
    EventLocale(
        pk = pk,
        event = event.toEvent(),
        language = language.toLanguage(),
        about = about,
        name = name,
        description = description
    )