package by.ssrlab.common_ui.common.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FExhibitVM: ViewModel() {

    val title = MutableLiveData("")
    val body = MutableLiveData("")
}