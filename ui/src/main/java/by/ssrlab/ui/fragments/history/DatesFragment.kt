package by.ssrlab.ui.fragments.history

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.ssrlab.common_ui.common.fragments.BaseFragment
import by.ssrlab.data.util.MainActivityUiState
import by.ssrlab.data.util.ToolbarStateByDates
import by.ssrlab.domain.models.ToolbarControlObject
import by.ssrlab.ui.MainActivity
import by.ssrlab.ui.databinding.FragmentDatesBinding
import by.ssrlab.ui.rv.DatesAdapter
import by.ssrlab.ui.vm.FDatesVM
import org.koin.android.ext.android.get

class DatesFragment: BaseFragment() {

    private lateinit var binding: FragmentDatesBinding
    private lateinit var adapter: DatesAdapter

    override val toolbarControlObject = ToolbarControlObject(
        isBack = false,
        isLang = true,
        isSearch = true,
        isDates = false
    )

    override val fragmentViewModel: FDatesVM by viewModels {
        FDatesVM.Factory(get())
    }

    override fun onStart() {
        super.onStart()

        (requireActivity() as MainActivity).apply {
            changeLayoutState(MainActivityUiState.DateFragment)
            setupToolbarByDates(ToolbarStateByDates.OnCreate)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityVM.setHeaderImg(by.ssrlab.common_ui.R.drawable.header_dates)
        //TODO Set date transformation in the viewModel

        initAdapter()
    }

    override fun onStop() {
        super.onStop()

        (requireActivity() as MainActivity).apply {
            changeLayoutState(MainActivityUiState.Other)
            setupToolbarByDates(ToolbarStateByDates.OnDestroy)
        }
    }

    override fun initAdapter() {
        adapter = DatesAdapter(fragmentViewModel.getData(), "Test test test")

        binding.apply {
            datesRv.layoutManager = LinearLayoutManager(requireContext())
            datesRv.adapter = adapter
        }
    }

    override fun initBinding(container: ViewGroup?): View {
        binding = FragmentDatesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onBackPressed() {
        findNavController().popBackStack()
    }

    override fun navigateNext(address: Int) {
        //TODO
    }
}