package by.ssrlab.common_ui.common.fragments.utils

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import by.ssrlab.common_ui.common.fragments.BaseFragment
import by.ssrlab.data.obj.ctrl.ToolbarControlObject

class FilterFragment: BaseFragment() {

    override val toolbarControlObject = by.ssrlab.data.obj.ctrl.ToolbarControlObject(
        isBack = false,
        isLang = true,
        isSearch = true,
        isDates = false
    )

    override val viewModel: ViewModel
        get() = TODO("Not yet implemented")

    override fun initBinding(container: ViewGroup?): View {
        TODO("Not yet implemented")
    }
}