package by.ssrlab.ui.fragments.inventions

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.ssrlab.common_ui.common.fragments.BaseFragment
import by.ssrlab.data.util.ButtonAction
import by.ssrlab.domain.models.ToolbarControlObject
import by.ssrlab.ui.MainActivity
import by.ssrlab.ui.R
import by.ssrlab.ui.databinding.FragmentDevelopmentsBinding
import by.ssrlab.ui.rv.SectionAdapter
import by.ssrlab.ui.vm.FDevelopmentsVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class DevelopmentsFragment: BaseFragment() {

    private lateinit var binding: FragmentDevelopmentsBinding
    private lateinit var adapter: SectionAdapter

    override val toolbarControlObject = ToolbarControlObject(
        isBack = true,
        isLang = false,
        isSearch = true,
        isDates = false
    )

    override val fragmentViewModel: FDevelopmentsVM by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentViewModel.setTitle(requireContext().resources.getString(by.ssrlab.domain.R.string.folder_inventions))
        activityVM.apply {
            setHeaderImg(by.ssrlab.common_ui.R.drawable.header_inventions)
            setButtonAction(ButtonAction.BackAction, ::onBackPressed)
        }

        binding.apply {
            viewModel = this@DevelopmentsFragment.fragmentViewModel
            lifecycleOwner = viewLifecycleOwner
        }

        initAdapter()
        observeOnDataChanged()
    }

    override fun observeOnDataChanged() {
        fragmentViewModel.inventionsData.observe(viewLifecycleOwner) {
            adapter.updateData(it)
        }
    }

    override fun initAdapter() {
        adapter = SectionAdapter(fragmentViewModel.inventionsData.value!!) {
            navigateNext()
        }

        binding.apply {
            inventionsRv.adapter = adapter
            inventionsRv.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun initBinding(container: ViewGroup?): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_developments, container, false)
        return binding.root
    }

    override fun onBackPressed() {
        findNavController().popBackStack()
    }

    override fun navigateNext() {
        (activity as MainActivity).moveToExhibit()
    }
}