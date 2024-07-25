package by.ssrlab.domain.repository.network

import by.ssrlab.data.api.PlacesApi

class PlacesRepository(private val api: PlacesApi) {

    fun get(language: Int) = api.get(language)
}