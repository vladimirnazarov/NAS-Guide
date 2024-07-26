package by.ssrlab.domain.repository.network

import by.ssrlab.data.api.EventsApi
import by.ssrlab.data.data.EventLocale
import by.ssrlab.domain.repository.network.base.BaseRepository

class EventsRepository(private val api: EventsApi): BaseRepository<EventLocale> {

    override fun get(language: Int) = api.get(language)
}