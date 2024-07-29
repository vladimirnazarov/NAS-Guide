package by.ssrlab.domain.repository.network

import by.ssrlab.data.api.PlacesApi
import by.ssrlab.data.data.PlaceLocale
import by.ssrlab.domain.repository.network.base.BaseRepository

class PlacesRepository(private val api: PlacesApi): BaseRepository<PlaceLocale> {

    override fun get(language: Int) = api.get(language)
}