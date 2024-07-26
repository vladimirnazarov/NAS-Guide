package by.ssrlab.ui.fragments.organizations

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.ssrlab.common_ui.common.fragments.BaseFragment
import by.ssrlab.domain.models.ToolbarControlObject
import by.ssrlab.ui.MainActivity
import by.ssrlab.ui.R
import by.ssrlab.ui.databinding.FragmentOrgsBinding
import by.ssrlab.ui.rv.SectionAdapter
import by.ssrlab.ui.vm.FOrgsVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrgsFragment: BaseFragment() {

    private lateinit var binding: FragmentOrgsBinding
    private lateinit var adapter: SectionAdapter

    override val toolbarControlObject = ToolbarControlObject(
        isBack = true,
        isLang = false,
        isSearch = true,
        isDates = false
    )

    override val fragmentViewModel: FOrgsVM by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentViewModel.setTitle(requireContext().resources.getString(by.ssrlab.domain.R.string.folder_organizations))
        activityVM.setHeaderImg(by.ssrlab.common_ui.R.drawable.header_organizations)

        binding.apply {
            viewModel = this@OrgsFragment.fragmentViewModel
            lifecycleOwner = viewLifecycleOwner
        }

        initAdapter()
        observeOnDataChanged()
    }

    override fun observeOnDataChanged() {
        fragmentViewModel.orgsData.observe(viewLifecycleOwner) {
            adapter.updateData(it)
        }
    }

    override fun initAdapter() {
        adapter = SectionAdapter(fragmentViewModel.orgsData.value!!) {
            navigateNext()
        }

        binding.apply {
            orgsRv.adapter = adapter
            orgsRv.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun initBinding(container: ViewGroup?): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_orgs, container, false)
        return binding.root
    }

    override fun onBackPressed() {
        findNavController().popBackStack()
    }

    override fun navigateNext(address: Int) {
        (activity as MainActivity).moveToExhibit()
    }
}