package by.ssrlab.common_ui.common.vm

import androidx.lifecycle.ViewModel
import by.ssrlab.data.data.common.RepositoryData
import by.ssrlab.domain.repository.network.base.BaseRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class BaseFragmentVM<T: RepositoryData>(private val baseRepository: BaseRepository<T>): ViewModel() {

    private val networkScope = CoroutineScope(Dispatchers.IO + Job())
    private val uiScope = CoroutineScope(Dispatchers.Main + Job())

    fun getData(onSuccess: (List<T>) -> Unit) {
        networkScope.launch {
            baseRepository.get(2).enqueue(object : Callback<List<T>> {
                override fun onResponse(p0: Call<List<T>>, p1: Response<List<T>>) {
                    uiScope.launch { onSuccess(p1.body() ?: listOf()) }
                }

                override fun onFailure(p0: Call<List<T>>, p1: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}