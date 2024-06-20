package by.ssrlab.common_ui.common.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import by.ssrlab.common_ui.common.vm.AMainVM
import coil.load
import coil.transform.RoundedCornersTransformation
import org.koin.androidx.viewmodel.ext.android.activityViewModel

abstract class BaseFragment: Fragment() {

    abstract val viewModel: ViewModel
    val activityVM: AMainVM by activityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireActivity() as AppCompatActivity).onBackPressedDispatcher.addCallback(this) {
            onBackPressed()
        }

        initActivity()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return initBinding(container)
    }

    abstract fun initBinding(container: ViewGroup?): View
    open fun onBackPressed() {}
    open fun initActivity() {}
    open fun navigateNext(address: Int) {}
    open fun loadImage(imageView: ImageView, imageId: Int) {
        imageView.load(imageId) {
            transformations(RoundedCornersTransformation(20f))
        }
    }
}