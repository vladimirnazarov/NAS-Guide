package by.ssrlab.common_ui.common

import android.os.Bundle
import android.view.ViewTreeObserver
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import by.ssrlab.common_ui.common.fragments.utils.ActivityMainMarginParams
import by.ssrlab.common_ui.common.vm.AExhibitVM
import by.ssrlab.common_ui.databinding.ActivityExhibitBinding
import coil.load
import coil.transform.RoundedCornersTransformation
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

class ExhibitActivity : AppCompatActivity(), KoinComponent {

    private lateinit var binding: ActivityExhibitBinding
    private val activityViewModel: AExhibitVM by viewModel()

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

        binding = ActivityExhibitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeLayoutChange()
//        observeHeader()
    }

    private fun observeHeader() {
        activityViewModel.header.observe(this@ExhibitActivity) {
            binding.activityHeader.load(it) {
                transformations(RoundedCornersTransformation(bottomRight = 60f))
            }
        }
    }

    private fun observeLayoutChange() {
        binding.root.viewTreeObserver.addOnGlobalLayoutListener(object: ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                binding.root.viewTreeObserver.removeOnGlobalLayoutListener(this)

                val statusBarHeight = getPadding(ActivityMainMarginParams.STATUS_HEIGHT)
                val navBarHeight = getPadding(ActivityMainMarginParams.NAVIGATION_HEIGHT)

                val toolbarParams = binding.toolbar.layoutParams as ConstraintLayout.LayoutParams
                toolbarParams.topMargin = statusBarHeight
                binding.toolbar.layoutParams = toolbarParams

                val bottomBlurParams = binding.activityBottomBlur.layoutParams
                bottomBlurParams.height = navBarHeight
                binding.activityBottomBlur.layoutParams = bottomBlurParams
            }
        })
    }

    @Suppress("DiscouragedApi")
    private fun getPadding(identifier: ActivityMainMarginParams): Int {
        var result = 0
        val resourceId = resources.getIdentifier(identifier.param, "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }

        return result
    }
}