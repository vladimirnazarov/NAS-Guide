package by.ssrlab.ui.fragments.organizations.child

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import by.ssrlab.common_ui.common.fragments.BaseFragment
import by.ssrlab.common_ui.common.obj.ctrl.ToolbarControlObject

class ContactsFragment: BaseFragment() {

    override val toolbarControlObject = ToolbarControlObject(
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