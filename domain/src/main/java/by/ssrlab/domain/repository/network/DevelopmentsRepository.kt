package by.ssrlab.domain.repository.network

import by.ssrlab.data.api.DevelopmentsApi
import by.ssrlab.data.data.DevelopmentLocale
import by.ssrlab.domain.repository.network.base.BaseRepository

class DevelopmentsRepository(private val api: DevelopmentsApi): BaseRepository<DevelopmentLocale> {

    override fun get(language: Int) = api.get(language)
}