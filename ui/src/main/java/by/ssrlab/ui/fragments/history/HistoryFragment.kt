package by.ssrlab.ui.fragments.history

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import by.ssrlab.common_ui.common.fragments.BaseFragment
import by.ssrlab.ui.R
import by.ssrlab.ui.databinding.FragmentHistoryBinding
import by.ssrlab.ui.vm.FHistoryVM
import org.koin.android.ext.android.get

class HistoryFragment: BaseFragment() {

    private lateinit var binding: FragmentHistoryBinding
    override val viewModel: FHistoryVM by viewModels {
        FHistoryVM.Factory(get())
    }

    override fun initBinding(container: ViewGroup?): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_history, container, false)
        return binding.root
    }
}