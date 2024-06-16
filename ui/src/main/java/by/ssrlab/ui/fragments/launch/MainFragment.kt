package by.ssrlab.ui.fragments.launch

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.ssrlab.common_ui.common.fragments.BaseFragment
import by.ssrlab.common_ui.common.repository.UiDataProvider
import by.ssrlab.ui.R
import by.ssrlab.ui.databinding.FragmentMainBinding
import by.ssrlab.ui.rv.FragmentMainAdapter
import by.ssrlab.ui.vm.FMainVM

class MainFragment: BaseFragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: FragmentMainAdapter
    private val mainViewModel: FMainVM by viewModels {
        FMainVM.Factory(UiDataProvider(requireContext()))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.setTitle(requireContext().resources.getString(R.string.page_main_title))

        binding.apply {
            viewModel = mainViewModel
            lifecycleOwner = viewLifecycleOwner

            initAdapter()
        }
    }

    private fun initAdapter() {
        adapter = FragmentMainAdapter(mainViewModel.getData())
        binding.apply {
            mainRv.layoutManager = LinearLayoutManager(requireContext())
            mainRv.adapter = adapter
        }
    }

    override fun initBinding(): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }
}