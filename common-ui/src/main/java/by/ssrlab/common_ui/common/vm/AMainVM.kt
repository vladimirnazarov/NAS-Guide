package by.ssrlab.common_ui.common.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AMainVM: ViewModel() {

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

    fun setupButtons(isBack: Boolean, isLang: Boolean, isSearch: Boolean, isDates: Boolean) {
        _isBackVisible.value = isBack
        _isLangVisible.value = isLang
        _isSearchVisible.value = isSearch
        _isDatesVisible.value = isDates
    }
}