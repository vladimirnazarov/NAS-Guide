package by.ssrlab.common_ui.common.vm

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AMainVM(private val context: Context): ViewModel() {

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

    @Suppress("DiscouragedApi")
    fun getPadding(identifier: ActivityMainMarginParams): Int {
        var result = 0
        val resourceId = context.resources.getIdentifier(identifier.param, "dimen", "android")
        if (resourceId > 0) {
            result = context.resources.getDimensionPixelSize(resourceId)
        }

        return result
    }
}