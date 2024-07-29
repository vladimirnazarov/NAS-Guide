package by.ssrlab.ui.fragments.history

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.ssrlab.common_ui.common.fragments.BaseFragment
import by.ssrlab.domain.models.ToolbarControlObject
import by.ssrlab.ui.MainActivity
import by.ssrlab.ui.R
import by.ssrlab.ui.databinding.FragmentPersonsBinding
import by.ssrlab.ui.rv.GridAdapter
import by.ssrlab.ui.vm.FPersonsVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class PersonsFragment: BaseFragment() {

    private lateinit var binding: FragmentPersonsBinding
    private lateinit var adapter: GridAdapter

    override val toolbarControlObject = ToolbarControlObject(
        isBack = true,
        isLang = false,
        isSearch = true,
        isDates = false
    )

    override val fragmentViewModel: FPersonsVM by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentViewModel.setTitle(requireContext().resources.getString(R.string.page_persons_title))
        activityVM.setHeaderImg(by.ssrlab.common_ui.R.drawable.header_persons)

        binding.apply {
            viewModel = this@PersonsFragment.fragmentViewModel
            lifecycleOwner = viewLifecycleOwner
        }

        initAdapter()
        observeOnDataChanged()
    }

    override fun observeOnDataChanged() {
        fragmentViewModel.personsData.observe(viewLifecycleOwner) {
            adapter.updateData(it)
        }
    }

    override fun initAdapter() {
        adapter = GridAdapter(fragmentViewModel.personsData.value!!) {
            navigateNext()
        }

        binding.apply {
            personsRv.adapter = adapter
            personsRv.layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    override fun initBinding(container: ViewGroup?): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_persons, container, false)
        return binding.root
    }

    override fun onBackPressed() {
        findNavController().popBackStack()
    }

    override fun navigateNext() {
        (activity as MainActivity).moveToExhibit()
    }
}