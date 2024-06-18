package by.ssrlab.ui.vm.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.ssrlab.ui.repository.UiDataProvider
import org.koin.core.component.KoinComponent

class FMainVM(private val uiDataProvider: UiDataProvider): ViewModel(), KoinComponent{

    @Suppress("UNCHECKED_CAST")
    class Factory(private val uiDataProvider: UiDataProvider): ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return FMainVM(uiDataProvider) as T
        }
    }

    private val _title = MutableLiveData("")
    val title: LiveData<String>
        get() = _title

    fun getData() = uiDataProvider.getMainFolders()
    fun setTitle(value: String) {
        _title.value = value
    }
}