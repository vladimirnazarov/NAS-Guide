package by.ssrlab.data.data.settings.mappers

import by.ssrlab.data.data.mappers.toLanguage
import by.ssrlab.data.data.mappers.toLanguageEntity
import by.ssrlab.data.data.mappers.toOrganization
import by.ssrlab.data.data.mappers.toOrganizationEntity
import by.ssrlab.data.data.settings.locale.OrganizationLocaleEntity
import by.ssrlab.data.data.settings.remote.OrganizationLocale

fun OrganizationLocale.toOrganizationLocaleEntity(): OrganizationLocaleEntity {
    return OrganizationLocaleEntity(
        pk = pk,
        description = description.toOrganizationEntity(),
        language = language.toLanguageEntity(),
        about = about,
        audio = audio,
        name = name,
        contacts = contacts,
        achievements = achievements,
        researchAreas = researchAreas
    )
}

fun OrganizationLocaleEntity.toOrganizationLocale(): OrganizationLocale {
    return OrganizationLocale(
        pk = pk,
        description = description.toOrganization(),
        language = language.toLanguage(),
        about = about,
        audio = audio,
        name = name,
        contacts = contacts,
        achievements = achievements,
        researchAreas = researchAreas
    )
}