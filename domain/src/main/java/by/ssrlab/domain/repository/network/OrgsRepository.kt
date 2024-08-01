package by.ssrlab.domain.repository.network

import by.ssrlab.data.api.OrgsApi
import by.ssrlab.data.data.settings.remote.OrganizationLocale
import by.ssrlab.domain.repository.network.base.BaseRepository

class OrgsRepository(private val api: OrgsApi): BaseRepository<OrganizationLocale> {

    override fun get(language: Int) = api.get(language)
}