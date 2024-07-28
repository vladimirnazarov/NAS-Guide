package by.ssrlab.domain.repository.network

import by.ssrlab.data.api.EventsApi

class EventsRepository(private val api: EventsApi) {

    fun get(language: Int) = api.get(language)
}