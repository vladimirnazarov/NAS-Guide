package by.ssrlab.common_ui.common.ui.base.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import by.ssrlab.data.data.common.RepositoryData
import by.ssrlab.domain.models.SharedPreferencesUtil
import by.ssrlab.domain.repository.network.base.BaseRepository
import by.ssrlab.domain.utils.transformLanguageToInt
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class BaseFragmentVM<T : RepositoryData>(private val baseRepository: BaseRepository<T>) :
    ViewModel(), KoinComponent {

    private val networkScope = CoroutineScope(Dispatchers.IO + Job())
    private val uiScope = CoroutineScope(Dispatchers.Main + Job())
    private val sharedPreferences: SharedPreferencesUtil by inject()

    fun getData(onSuccess: (List<T>) -> Unit) {
        networkScope.launch {
            baseRepository.get(sharedPreferences.getLanguage()!!.transformLanguageToInt()).enqueue(object : Callback<List<T>> {
                override fun onResponse(p0: Call<List<T>>, p1: Response<List<T>>) {
                    uiScope.launch { onSuccess(p1.body() ?: listOf()) }
                }

                override fun onFailure(p0: Call<List<T>>, p1: Throwable) {
                    Log.e(REQUEST_ERROR_LOG, p1.message.toString())
                }
            })
        }
    }

    companion object {
        private const val REQUEST_ERROR_LOG = "request_error_log"
    }
}