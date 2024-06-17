package by.ssrlab.ui.vm

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.ssrlab.ui.R

class AMainVM(private val resources: Resources): ViewModel() {

    enum class ActivityMainMarginParams(val param: String) {
        STATUS_HEIGHT("status_bar_height"),
        NAVIGATION_HEIGHT("navigation_bar_height")
    }

    @Suppress("UNCHECKED_CAST")
    class Factory(private val resources: Resources): ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AMainVM(resources) as T
        }
    }

    private val _headerImg = MutableLiveData(0)
    val headerImg: LiveData<Int>
        get() = _headerImg

    fun setHeaderImg(resource: Int) {
        _headerImg.value = resource
    }

    @Suppress("DiscouragedApi")
    fun getPadding(identifier: ActivityMainMarginParams): Int {
        var result = 0
        val resourceId = resources.getIdentifier(identifier.param, "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }

        return result
    }
}