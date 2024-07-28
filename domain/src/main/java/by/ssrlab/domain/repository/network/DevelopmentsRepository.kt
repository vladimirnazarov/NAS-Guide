package by.ssrlab.domain.repository.network

import by.ssrlab.data.api.DevelopmentsApi

class DevelopmentsRepository(private val api: DevelopmentsApi) {

    fun get(language: Int) = api.get(language)
}