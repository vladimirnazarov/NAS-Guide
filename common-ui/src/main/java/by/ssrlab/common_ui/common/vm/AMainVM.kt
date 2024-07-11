package by.ssrlab.common_ui.common.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.ssrlab.common_ui.common.obj.ctrl.ToolbarControlObject

class AMainVM: ViewModel() {

    enum class ActivityMainMarginParams(val param: String) {
        STATUS_HEIGHT("status_bar_height"),
        NAVIGATION_HEIGHT("navigation_bar_height")
    }

    private val _headerImg = MutableLiveData(0)
    val headerImg: LiveData<Int>
        get() = _headerImg

    fun setHeaderImg(resource: Int) {
        _headerImg.value = resource
    }

    private val _isBackVisible = MutableLiveData(false)
    private val _isLangVisible = MutableLiveData(false)
    private val _isSearchVisible = MutableLiveData(false)
    private val _isDatesVisible = MutableLiveData(false)

    val isBackVisible: LiveData<Boolean> get() = _isBackVisible
    val isLangVisible: LiveData<Boolean> get() = _isLangVisible
    val isSearchVisible: LiveData<Boolean> get() = _isSearchVisible
    val isDatesVisible: LiveData<Boolean> get() = _isDatesVisible

    fun setupButtons(toolbarControlObject: ToolbarControlObject) {
        _isBackVisible.value = toolbarControlObject.isBack
        _isLangVisible.value = toolbarControlObject.isLang
        _isSearchVisible.value = toolbarControlObject.isSearch
        _isDatesVisible.value = toolbarControlObject.isDates
    }
}