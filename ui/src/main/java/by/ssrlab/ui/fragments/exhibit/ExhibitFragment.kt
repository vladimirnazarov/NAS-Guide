package by.ssrlab.ui.fragments.exhibit

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import by.ssrlab.common_ui.common.fragments.BaseFragment
import by.ssrlab.common_ui.common.obj.ctrl.ToolbarControlObject
import by.ssrlab.common_ui.databinding.FragmentExhibitBinding

class ExhibitFragment: BaseFragment() {

    override val toolbarControlObject = ToolbarControlObject(
        isBack = true,
        isLang = false,
        isSearch = true,
        isDates = false
    )

    override val viewModel: ViewModel
        get() = TODO("Not yet implemented")

    override fun initBinding(container: ViewGroup?): View {
        val binding = FragmentExhibitBinding.inflate(layoutInflater)
        return binding.root
    }

}