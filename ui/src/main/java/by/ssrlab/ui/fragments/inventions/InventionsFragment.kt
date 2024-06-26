package by.ssrlab.ui.fragments.inventions

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import by.ssrlab.common_ui.common.fragments.BaseFragment
import by.ssrlab.ui.R
import by.ssrlab.ui.databinding.FragmentInventionsBinding
import by.ssrlab.ui.rv.section.SectionAdapter
import by.ssrlab.ui.vm.FInventionsVM

class InventionsFragment: BaseFragment() {

    override val viewModel: FInventionsVM by viewModels()
    private lateinit var binding: FragmentInventionsBinding
    private lateinit var adapter: SectionAdapter

    override fun initBinding(container: ViewGroup?): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_inventions, container, false)
        return binding.root
    }
}