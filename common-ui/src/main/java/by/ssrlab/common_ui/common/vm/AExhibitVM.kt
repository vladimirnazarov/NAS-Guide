package by.ssrlab.common_ui.common.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AExhibitVM: ViewModel() {

    private val _header = MutableLiveData("")
    val header: LiveData<String>
        get() = _header

    fun setHeader(res: String) {
        _header.value = res
    }
}