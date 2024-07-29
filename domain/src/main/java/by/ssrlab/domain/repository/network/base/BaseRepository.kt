package by.ssrlab.domain.repository.network.base

import by.ssrlab.data.data.common.RepositoryData
import retrofit2.Call

interface BaseRepository<T: RepositoryData> {

    fun get(language: Int): Call<List<T>>
}