package by.ssrlab.ui.fragments.launch

import android.view.View
import by.ssrlab.common_ui.common.fragments.BaseFragment
import by.ssrlab.ui.databinding.FragmentMainBinding

class MainFragment: BaseFragment() {

    private lateinit var binding: FragmentMainBinding

    override fun initBinding(): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }
}