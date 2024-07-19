package by.ssrlab.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import by.ssrlab.common_ui.common.ExhibitActivity
import by.ssrlab.common_ui.common.fragments.utils.ActivityMainMarginParams
import by.ssrlab.common_ui.common.vm.AMainVM
import by.ssrlab.ui.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

//class MainActivity : AppCompatActivity(), KoinComponent {
//
//    private lateinit var binding: ActivityMainBinding
//    private val activityViewModel: AMainVM by viewModel()
//
//    private lateinit var container: ConstraintLayout
//    private lateinit var transition: AutoTransition
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge(
//            statusBarStyle = SystemBarStyle.dark(
//                android.graphics.Color.TRANSPARENT
//            ),
//            navigationBarStyle = SystemBarStyle.dark(
//                android.graphics.Color.TRANSPARENT
//            )
//        )
//
//        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
//
//        binding.viewModel = activityViewModel
//        binding.lifecycleOwner = this@MainActivity
//
//        observeLayoutChange()
//        observeHeader()
//        observeButtonsState()
//    }
//
//    private fun observeLayoutChange() {
//        binding.root.viewTreeObserver.addOnGlobalLayoutListener(object: ViewTreeObserver.OnGlobalLayoutListener {
//            override fun onGlobalLayout() {
//                binding.root.viewTreeObserver.removeOnGlobalLayoutListener(this)
//
//                val statusBarHeight = getPadding(ActivityMainMarginParams.STATUS_HEIGHT)
//                val navBarHeight = getPadding(ActivityMainMarginParams.NAVIGATION_HEIGHT)
//
//                val toolbarParams = binding.toolbar.layoutParams as ConstraintLayout.LayoutParams
//                toolbarParams.topMargin = statusBarHeight
//                binding.toolbar.layoutParams = toolbarParams
//
//                val bottomBlurParams = binding.activityBottomBlur.layoutParams
//                bottomBlurParams.height = navBarHeight
//                binding.activityBottomBlur.layoutParams = bottomBlurParams
//            }
//        })
//    }
//
//    @SuppressLint("UseCompatLoadingForDrawables")
//    private fun observeHeader() {
//        activityViewModel.headerImg.observe(this) {
//            val currentDrawable = binding.activityHeader.drawable
//            val newDrawable = resources.getDrawable(it, null)
//
//            if (currentDrawable != null) {
//                val transitionDrawable = TransitionDrawable(arrayOf(currentDrawable, newDrawable))
//                binding.activityHeader.setImageDrawable(transitionDrawable)
//                transitionDrawable.startTransition(100)
//            } else {
//                binding.activityHeader.setImageDrawable(newDrawable)
//            }
//        }
//    }
//
//    private fun observeButtonsState() {
//        container = binding.toolbar
//        transition = AutoTransition().apply {
//            duration = 75
//            interpolator = AccelerateDecelerateInterpolator()
//        }
//
//        activityViewModel.apply {
//            isBackVisible.observe(this@MainActivity) { animateButton(binding.toolbarBack, it) }
//            isLangVisible.observe(this@MainActivity) { animateButton(binding.toolbarLang, it) }
//            isSearchVisible.observe(this@MainActivity) { animateButton(binding.toolbarSearch, it) }
//            isDatesVisible.observe(this@MainActivity) { animateButton(binding.toolbarDate, it) }
//        }
//    }
//
//    @Suppress("DiscouragedApi")
//    private fun getPadding(identifier: ActivityMainMarginParams): Int {
//        var result = 0
//        val resourceId = resources.getIdentifier(identifier.param, "dimen", "android")
//        if (resourceId > 0) {
//            result = resources.getDimensionPixelSize(resourceId)
//        }
//
//        return result
//    }
//
//    private fun animateButton(button: View, visible: Boolean) {
//        TransitionManager.beginDelayedTransition(container, transition)
//
//        if (visible) button.visibility = View.VISIBLE
//        else button.visibility = View.GONE
//    }
//
//    fun moveToExhibit() {
//        val intent = Intent(this, ExhibitActivity::class.java)
//        startActivity(intent)
//    }
//}