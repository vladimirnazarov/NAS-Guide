package by.ssrlab.ui

import android.os.Bundle
import android.view.ViewTreeObserver
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import by.ssrlab.ui.databinding.ActivityMainBinding
import by.ssrlab.ui.vm.AMainVM
import coil.load

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: AMainVM by viewModels {
        AMainVM.Factory(resources)
    }

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

        binding.viewModel = viewModel
        binding.lifecycleOwner = this@MainActivity

        observeLayoutChange()
        observeHeader()
    }

    private fun observeLayoutChange() {
        binding.root.viewTreeObserver.addOnGlobalLayoutListener(object: ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                binding.root.viewTreeObserver.removeOnGlobalLayoutListener(this)

                val statusBarHeight = viewModel.getPadding(AMainVM.ActivityMainMarginParams.STATUS_HEIGHT)
                val navBarHeight = viewModel.getPadding(AMainVM.ActivityMainMarginParams.NAVIGATION_HEIGHT)

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
        viewModel.headerImg.observe(this) {
            binding.activityHeader.load(it)
        }
    }

    fun provideViewModel() = viewModel
}