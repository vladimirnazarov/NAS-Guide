package by.ssrlab.ui.fragments.history

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.ssrlab.common_ui.common.fragments.BaseFragment
import by.ssrlab.ui.MainActivity
import by.ssrlab.ui.R
import by.ssrlab.ui.databinding.FragmentHistoryBinding
import by.ssrlab.ui.rv.FragmentHistoryAdapter
import by.ssrlab.ui.vm.FHistoryVM
import org.koin.android.ext.android.get

class HistoryFragment: BaseFragment() {

    private lateinit var binding: FragmentHistoryBinding
    private lateinit var adapter: FragmentHistoryAdapter
    override val viewModel: FHistoryVM by viewModels {
        FHistoryVM.Factory(get())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setTitle(requireContext().resources.getString(R.string.page_history_title))
        activityVM.setHeaderImg(R.drawable.header_history)

        binding.apply {
            viewModel = this@HistoryFragment.viewModel
            lifecycleOwner = viewLifecycleOwner

            initAdapter()
        }
    }

    private fun initAdapter() {
        adapter = FragmentHistoryAdapter(viewModel.getData(), { image, resource ->
            loadImage(image, resource)
        }, { address ->
            navigateNext(address)
        })

        binding.apply {
            historyRv.layoutManager = LinearLayoutManager(requireContext())
            historyRv.adapter = adapter
        }
    }

    override fun initBinding(container: ViewGroup?): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_history, container, false)
        return binding.root
    }

    override fun onBackPressed() {
        findNavController().popBackStack()
    }

    override fun navigateNext(address: Int) {
//        findNavController().navigate(address)
    }
}