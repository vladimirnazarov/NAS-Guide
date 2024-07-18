package by.ssrlab.common_ui.common.fragments.utils

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import by.ssrlab.common_ui.common.fragments.BaseFragment

class SearchFragment: BaseFragment() {

    override val toolbarControlObject = by.ssrlab.domain.models.ToolbarControlObject(
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