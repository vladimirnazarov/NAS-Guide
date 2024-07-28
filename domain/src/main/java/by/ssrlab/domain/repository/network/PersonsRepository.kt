package by.ssrlab.domain.repository.network

import by.ssrlab.data.api.PersonsApi

class PersonsRepository(private val api: PersonsApi) {

    fun get(language: Int) = api.get(language)
}