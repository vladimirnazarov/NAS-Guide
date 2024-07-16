package by.ssrlab.common_ui.common.fragments.exhibit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.ssrlab.common_ui.common.vm.FExhibitVM
import by.ssrlab.common_ui.databinding.FragmentExhibitBinding

class ExhibitFragment: Fragment() {

    private lateinit var binding: FragmentExhibitBinding
    private val viewModel: FExhibitVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExhibitBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.apply {
            title.value = "Test"
            body.value = "Test ".repeat(100)
        }
    }
}