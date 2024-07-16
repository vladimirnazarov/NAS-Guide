package by.ssrlab.ui.fragments.organizations

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.ssrlab.common_ui.common.fragments.BaseFragment
import by.ssrlab.data.obj.ctrl.ToolbarControlObject
import by.ssrlab.ui.MainActivity
import by.ssrlab.ui.R
import by.ssrlab.ui.databinding.FragmentOrgsBinding
import by.ssrlab.ui.rv.SectionsAdapter
import by.ssrlab.ui.vm.FOrgsVM
import org.koin.android.ext.android.get

class OrgsFragment: BaseFragment() {

    private lateinit var binding: FragmentOrgsBinding
    private lateinit var adapter: SectionsAdapter

    override val toolbarControlObject = by.ssrlab.data.obj.ctrl.ToolbarControlObject(
        isBack = true,
        isLang = false,
        isSearch = true,
        isDates = false
    )

    override val viewModel: FOrgsVM by viewModels {
        FOrgsVM.Factory(get())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setTitle(requireContext().resources.getString(by.ssrlab.common_ui.R.string.folder_organizations))
        activityVM.setHeaderImg(by.ssrlab.common_ui.R.drawable.header_organizations)

        binding.apply {
            viewModel = this@OrgsFragment.viewModel
            lifecycleOwner = viewLifecycleOwner

            initAdapter()
        }
    }

    override fun initAdapter() {
        adapter = SectionsAdapter(viewModel.getData()) {
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