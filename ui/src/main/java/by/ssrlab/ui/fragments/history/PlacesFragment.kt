package by.ssrlab.ui.fragments.history

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.ssrlab.common_ui.common.fragments.BaseFragment
import by.ssrlab.ui.MainActivity
import by.ssrlab.ui.R
import by.ssrlab.ui.databinding.FragmentPlacesBinding
import by.ssrlab.ui.rv.SectionsAdapter
import by.ssrlab.ui.vm.FPlacesVM
import org.koin.android.ext.android.get

class PlacesFragment: BaseFragment() {

    private lateinit var binding: FragmentPlacesBinding
    private lateinit var adapter: SectionsAdapter

    override val toolbarControlObject = by.ssrlab.domain.models.ToolbarControlObject(
        isBack = true,
        isLang = false,
        isSearch = true,
        isDates = false
    )

    override val viewModel: FPlacesVM by viewModels {
        FPlacesVM.Factory(get())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setTitle(requireContext().resources.getString(R.string.page_places_title))
        activityVM.setHeaderImg(by.ssrlab.common_ui.R.drawable.header_places)

        binding.apply {
            viewModel = this@PlacesFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        initAdapter()
    }

    override fun initAdapter() {
        adapter = SectionsAdapter(viewModel.getData()) {
            navigateNext()
        }

        binding.apply {
            placesRv.adapter = adapter
            placesRv.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun initBinding(container: ViewGroup?): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_places, container, false)
        return binding.root
    }

    override fun onBackPressed() {
        findNavController().popBackStack()
    }

    override fun navigateNext() {
        (activity as MainActivity).moveToExhibit()
    }
}