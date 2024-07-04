package by.ssrlab.ui

import android.os.Bundle
import android.view.ViewTreeObserver
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import by.ssrlab.common_ui.common.vm.AMainVM
import by.ssrlab.ui.databinding.ActivityMainBinding
import coil.load
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

class MainActivity : AppCompatActivity(), KoinComponent {

    private lateinit var binding: ActivityMainBinding
    private val activityViewModel: AMainVM by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                android.graphics.Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.dark(
                android.graphics.Color.TRANSPARENT
            )
        )

        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        binding.viewModel = activityViewModel
        binding.lifecycleOwner = this@MainActivity

        observeLayoutChange()
        observeHeader()
    }

    private fun observeLayoutChange() {
        binding.root.viewTreeObserver.addOnGlobalLayoutListener(object: ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                binding.root.viewTreeObserver.removeOnGlobalLayoutListener(this)

                val statusBarHeight = getPadding(AMainVM.ActivityMainMarginParams.STATUS_HEIGHT)
                val navBarHeight = getPadding(AMainVM.ActivityMainMarginParams.NAVIGATION_HEIGHT)

                val toolbarParams = binding.toolbar.layoutParams as ConstraintLayout.LayoutParams
                toolbarParams.topMargin = statusBarHeight
                binding.toolbar.layoutParams = toolbarParams

                val bottomBlurParams = binding.activityBottomBlur.layoutParams
                bottomBlurParams.height = navBarHeight
                binding.activityBottomBlur.layoutParams = bottomBlurParams
            }
        })
    }

    private fun observeHeader() {
        activityViewModel.headerImg.observe(this) {
            binding.activityHeader.load(it)
        }
    }

    private fun setupButtons() {
        //TODO
    }

    @Suppress("DiscouragedApi")
    private fun getPadding(identifier: AMainVM.ActivityMainMarginParams): Int {
        var result = 0
        val resourceId = resources.getIdentifier(identifier.param, "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }

        return result
    }
}