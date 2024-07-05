package by.ssrlab.ui.fragments

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.ssrlab.common_ui.common.fragments.BaseFragment
import by.ssrlab.ui.R
import by.ssrlab.ui.databinding.FragmentPersonsBinding
import by.ssrlab.ui.rv.grid.GridAdapter
import by.ssrlab.ui.vm.FPersonsVM
import org.koin.android.ext.android.get

class PersonsFragment: BaseFragment() {

    private lateinit var binding: FragmentPersonsBinding
    private lateinit var adapter: GridAdapter
    override val viewModel: FPersonsVM by viewModels {
        FPersonsVM.Factory(get())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setTitle(requireContext().resources.getString(R.string.page_persons_title))
        activityVM.setHeaderImg(by.ssrlab.common_ui.R.drawable.header_persons)

        binding.apply {
            viewModel = this@PersonsFragment.viewModel
            lifecycleOwner = viewLifecycleOwner

            initAdapter()
        }
    }

    private fun initAdapter() {
        adapter = GridAdapter(viewModel.getData()) { address ->
            navigateNext(address)
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

    override fun navigateNext(address: Int) {

    }
}