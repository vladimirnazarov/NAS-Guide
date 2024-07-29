package by.ssrlab.domain.repository.network

import by.ssrlab.data.api.PersonsApi
import by.ssrlab.data.data.PersonLocale
import by.ssrlab.domain.repository.network.base.BaseRepository

class PersonsRepository(private val api: PersonsApi): BaseRepository<PersonLocale> {

    override fun get(language: Int) = api.get(language)
}