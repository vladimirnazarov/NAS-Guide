package by.ssrlab.ui.fragments.history

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.ssrlab.common_ui.common.fragments.BaseFragment
import by.ssrlab.ui.databinding.FragmentDatesBinding
import by.ssrlab.ui.rv.DatesAdapter
import by.ssrlab.ui.vm.FDatesVM
import org.koin.android.ext.android.get

class DatesFragment: BaseFragment() {

    private lateinit var binding: FragmentDatesBinding
    private lateinit var adapter: DatesAdapter

    override val toolbarControlObject = by.ssrlab.domain.models.ToolbarControlObject(
        isBack = false,
        isLang = true,
        isSearch = true,
        isDates = false
    )

    override val viewModel: FDatesVM by viewModels {
        FDatesVM.Factory(get())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO Bind fragment under the image
        //TODO Set date transformation in the viewModel

        initAdapter()
    }

    override fun initAdapter() {
        //TODO
    }

    override fun initBinding(container: ViewGroup?): View {
        binding = FragmentDatesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onBackPressed() {
        findNavController().popBackStack()
    }
}