package by.ssrlab.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.ssrlab.common_ui.common.vm.BaseFragmentVM
import by.ssrlab.data.data.DevelopmentLocale
import by.ssrlab.domain.repository.network.DevelopmentsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FDevelopmentsVM(developmentsRepository: DevelopmentsRepository): BaseFragmentVM<DevelopmentLocale>(developmentsRepository) {

    private val _inventionsData = MutableLiveData<List<DevelopmentLocale>>(listOf())
    val inventionsData: LiveData<List<DevelopmentLocale>> get() = _inventionsData

    private val _title = MutableLiveData("")
    val title: LiveData<String>
        get() = _title

    fun setTitle(value: String) {
        _title.value = value
    }

    init {
        getData {
            _inventionsData.value = it
        }
    }
}