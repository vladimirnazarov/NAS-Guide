package by.ssrlab.ui.fragments.inventions

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.ssrlab.common_ui.common.fragments.BaseFragment
import by.ssrlab.common_ui.common.obj.ToolbarControlObject
import by.ssrlab.ui.R
import by.ssrlab.ui.databinding.FragmentInventionsBinding
import by.ssrlab.ui.rv.section.SectionsAdapter
import by.ssrlab.ui.vm.FInventionsVM
import org.koin.android.ext.android.get

class InventionsFragment: BaseFragment() {

    private lateinit var binding: FragmentInventionsBinding
    private lateinit var adapter: SectionsAdapter

    override val toolbarControlObject = ToolbarControlObject(
        isBack = true,
        isLang = false,
        isSearch = true,
        isDates = false
    )

    override val viewModel: FInventionsVM by viewModels {
        FInventionsVM.Factory(get())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setTitle(requireContext().resources.getString(by.ssrlab.common_ui.R.string.folder_inventions))
        activityVM.setHeaderImg(by.ssrlab.common_ui.R.drawable.header_inventions)

        binding.apply {
            viewModel = this@InventionsFragment.viewModel
            lifecycleOwner = viewLifecycleOwner

            initAdapter()
        }
    }

    private fun initAdapter() {
        adapter = SectionsAdapter(viewModel.getData()) { address ->
            navigateNext(address)
        }

        binding.apply {
            inventionsRv.adapter = adapter
            inventionsRv.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun initBinding(container: ViewGroup?): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_inventions, container, false)
        return binding.root
    }

    override fun onBackPressed() {
        findNavController().popBackStack()
    }

    override fun navigateNext(address: Int) {
        findNavController().navigate(R.id.action_inventionsFragment_to_exhibitFragment)
    }
}