package by.ssrlab.ui.fragments.launch

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.ssrlab.common_ui.common.fragments.BaseFragment
import by.ssrlab.ui.MainActivity
import by.ssrlab.ui.R
import by.ssrlab.ui.databinding.FragmentMainBinding
import by.ssrlab.ui.rv.FragmentMainAdapter
import by.ssrlab.ui.vm.FMainVM
import coil.load
import coil.transform.RoundedCornersTransformation
import org.koin.android.ext.android.get

class MainFragment: BaseFragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: FragmentMainAdapter
    private lateinit var activity: MainActivity
    override val viewModel: FMainVM by viewModels {
        FMainVM.Factory(get())
    }

    override fun initActivity() {
        activity = requireActivity() as MainActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setTitle(requireContext().resources.getString(R.string.page_main_title))
        activityVM.setHeaderImg(R.drawable.header_main)

        binding.apply {
            viewModel = this@MainFragment.viewModel
            lifecycleOwner = viewLifecycleOwner

            initAdapter()
        }
    }

    private fun initAdapter() {
        adapter = FragmentMainAdapter(viewModel.getData(), { image, resource ->
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

    override fun loadImage(imageView: ImageView, imageId: Int) {
        imageView.load(imageId) {
            transformations(RoundedCornersTransformation(resources.getDimension(by.ssrlab.common_ui.R.dimen.common_folder_corners)))
        }
    }

    override fun navigateNext(address: Int) {
        findNavController().navigate(address)
    }
}