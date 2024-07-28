package by.ssrlab.domain.repository.network

import by.ssrlab.data.api.OrgsApi

class OrgsRepository(private val api: OrgsApi) {

    fun get(language: Int) = api.get(language)
}