package by.ssrlab.ui.fragments

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.ssrlab.common_ui.common.fragments.BaseFragment
import by.ssrlab.domain.models.ToolbarControlObject
import by.ssrlab.ui.MainActivity
import by.ssrlab.ui.R
import by.ssrlab.ui.databinding.FragmentMainBinding
import by.ssrlab.ui.rv.FolderAdapter
import by.ssrlab.ui.vm.FMainVM
import org.koin.android.ext.android.get

class MainFragment: BaseFragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: FolderAdapter

    override val toolbarControlObject = ToolbarControlObject(
        isBack = false,
        isLang = true,
        isSearch = true,
        isDates = false
    )

    override val viewModel: FMainVM by viewModels {
        FMainVM.Factory(get())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setTitle(requireContext().resources.getString(R.string.page_main_title))
        activityVM.setHeaderImg(by.ssrlab.common_ui.R.drawable.header_main)

        binding.apply {
            viewModel = this@MainFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        initAdapter()
    }

    override fun initAdapter() {
        adapter = FolderAdapter(viewModel.getData(), { image, resource ->
            loadImage(image, resource)
        }, { address ->
            navigateNext(address)
        })

        binding.apply {
            mainRv.layoutManager = LinearLayoutManager(requireContext())
            mainRv.adapter = adapter
        }
    }

    override fun initBinding(container: ViewGroup?): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onBackPressed() {
        (requireActivity() as MainActivity).finish()
    }

    override fun navigateNext(address: Int) {
        findNavController().navigate(address)
    }
}