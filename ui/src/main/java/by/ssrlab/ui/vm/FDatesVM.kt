package by.ssrlab.ui.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.ssrlab.domain.ui.UiDataProvider

class FDatesVM(private val uiDataProvider: UiDataProvider): ViewModel() {

    @Suppress("UNCHECKED_CAST")
    class Factory(private val uiDataProvider: UiDataProvider): ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return FDatesVM(uiDataProvider) as T
        }
    }

    private val _date = MutableLiveData(0L)
    fun setDate(date: Long) {
        _date.value = date
    }

    private fun transformDate() {

    }

    fun getData() = uiDataProvider.getDates()
}