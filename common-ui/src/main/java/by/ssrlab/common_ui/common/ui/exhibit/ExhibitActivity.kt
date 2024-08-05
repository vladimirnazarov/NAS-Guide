package by.ssrlab.common_ui.common.ui.exhibit

import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.constraintlayout.widget.ConstraintLayout
import by.ssrlab.common_ui.common.ui.base.BaseActivity
import by.ssrlab.common_ui.common.ui.exhibit.fragments.utils.ActivityMainMarginParams
import by.ssrlab.common_ui.common.vm.AExhibitVM
import by.ssrlab.common_ui.databinding.ActivityExhibitBinding
import by.ssrlab.data.util.ExhibitObject
import coil.load
import coil.transform.RoundedCornersTransformation
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File

class ExhibitActivity : BaseActivity() {

    private lateinit var binding: ActivityExhibitBinding
    private val activityViewModel: AExhibitVM by viewModel()

    @Suppress("DEPRECATION")
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

        activityViewModel.apply {
            setData(intent.getParcelableExtra(PARCELABLE_DATA))
            if (repositoryData.value != null) observeHeader()
        }

        setupButtons()
        observeLayoutChange()

        val exhibitObject = getExhibitObjectFromIntent()
        checkAudioAvailability(exhibitObject)
    }

    private fun getExhibitObjectFromIntent(): ExhibitObject {
        return when (val exhibitObjectType = intent.getStringExtra("exhibitObjectType")) {
            "Development" -> ExhibitObject.Development
            "Organization" -> ExhibitObject.Organization
            "Person" -> ExhibitObject.Person
            "Place" -> ExhibitObject.Place
            else -> throw IllegalArgumentException("Invalid ExhibitObject type: $exhibitObjectType")
        }
    }

    private fun checkAudioAvailability(exhibitObject: ExhibitObject) {
        val audioFileName = "botanical_${getPlaceId(exhibitObject)}_${application.resources.configuration.locales.get(0)}.mp3"
        val audioFile = File(getExternalFilesDir(null), audioFileName)

        //TODO: check file availability

    }

    private fun getPlaceId(exhibitObject: ExhibitObject): String {
        return when (exhibitObject) {
            ExhibitObject.Development -> TODO()
            ExhibitObject.Organization -> TODO()
            ExhibitObject.Person -> TODO()
            ExhibitObject.Place -> TODO()
        }
    }

    private fun setupButtons() {
        setVolumeAction()
        setBackAction()
    }

    private fun setVolumeAction() {
        binding.toolbarVolume.setOnClickListener {
            createIsntRealizedDialog()
        }
    }

    private fun setBackAction() {
        binding.toolbarBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
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