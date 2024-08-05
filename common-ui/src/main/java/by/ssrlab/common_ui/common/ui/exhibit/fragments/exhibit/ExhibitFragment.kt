package by.ssrlab.common_ui.common.ui.exhibit.fragments.exhibit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.ssrlab.common_ui.common.ui.base.BaseActivity
import by.ssrlab.common_ui.common.ui.exhibit.ExhibitActivity
import by.ssrlab.common_ui.common.ui.exhibit.fragments.utils.MediaPlayer
import by.ssrlab.common_ui.common.vm.AExhibitVM
import by.ssrlab.common_ui.databinding.FragmentExhibitBinding
import by.ssrlab.data.data.common.RepositoryData
import by.ssrlab.data.data.settings.remote.DevelopmentLocale
import by.ssrlab.data.data.settings.remote.OrganizationLocale
import by.ssrlab.data.data.settings.remote.PersonLocale
import by.ssrlab.data.data.settings.remote.PlaceLocale
import by.ssrlab.data.util.ExhibitObject
import by.ssrlab.domain.utils.fromHtml
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import java.io.File

class ExhibitFragment : Fragment() {

    private lateinit var binding: FragmentExhibitBinding
    private val activityViewModel: AExhibitVM by activityViewModel()
    private val exhibitActivity: ExhibitActivity by lazy { (requireActivity() as ExhibitActivity) }

    private val scope = CoroutineScope(Dispatchers.Main)

    private lateinit var data: RepositoryData

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExhibitBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeOnParcelableData()
        disableButtons()
    }

    private fun disableButtons() {
        binding.apply {
            exhibitPlayRipple.setOnClickListener { (requireActivity() as BaseActivity).createIsntRealizedDialog() }
            exhibitPreviousRipple.setOnClickListener { (requireActivity() as BaseActivity).createIsntRealizedDialog() }
            exhibitNextRipple.setOnClickListener { (requireActivity() as BaseActivity).createIsntRealizedDialog() }
            exhibitContactsRipple.setOnClickListener { (requireActivity() as BaseActivity).createIsntRealizedDialog() }
            exhibitLabsRipple.setOnClickListener { (requireActivity() as BaseActivity).createIsntRealizedDialog() }
            exhibitAchievementsRipple.setOnClickListener { (requireActivity() as BaseActivity).createIsntRealizedDialog() }
            exhibitResearchRipple.setOnClickListener { (requireActivity() as BaseActivity).createIsntRealizedDialog() }
            exhibitDeveloperRipple.setOnClickListener { (requireActivity() as BaseActivity).createIsntRealizedDialog() }
        }
    }

    private fun observeOnParcelableData() {
        activityViewModel.repositoryData.observe(viewLifecycleOwner) {
            if (it != null) {
                data = it
                activityViewModel.setHeader(data.description!!.image.address)
            }

            when (it) {
                is DevelopmentLocale -> setParametersVisibility(ExhibitObject.Development)
                is OrganizationLocale -> setParametersVisibility(ExhibitObject.Organization)
                is PersonLocale -> setParametersVisibility(ExhibitObject.Person)
                is PlaceLocale -> setParametersVisibility(ExhibitObject.Place)
                null -> TODO()
            }
        }
    }

    private fun setParametersVisibility(exhibitObject: ExhibitObject) {
        binding.apply {
            when (exhibitObject) {
                ExhibitObject.Development -> {
                    exhibitDeveloperBlock.visibility = View.VISIBLE
                }

                ExhibitObject.Organization -> {
                    exhibitAdditionalBlock.visibility = View.VISIBLE
                    exhibitButtonMap.visibility = View.VISIBLE
                }

                ExhibitObject.Person -> {}
                ExhibitObject.Place -> {
                    exhibitButtonMap.visibility = View.VISIBLE
                }
            }

            if (data.audio != null) {
                exhibitPlayerBlock.visibility = View.VISIBLE
            }

            setParametersValues(exhibitObject)
        }
    }

    private fun setParametersValues(exhibitObject: ExhibitObject) {
        val data = activityViewModel.repositoryData.value!!

        binding.apply {
            exhibitTitle.text = data.name
            exhibitBody.text = data.about.fromHtml()

            if (exhibitObject is ExhibitObject.Development)
                exhibitDeveloperTitle.text =
                    (data as DevelopmentLocale).description.departmentFilter.keyName
        }
    }

    override fun onStop() {
        super.onStop()

        MediaPlayer.pauseAudio(binding)
    }

    private fun checkAudioAvailability() {
        val audioFileName = "botanical_${activityViewModel.getExhibitObject().placeId}_${exhibitActivity.getApp().getLocale()}.mp3"
        val audioFile = File(exhibitActivity.getExternalFilesDir(null), audioFileName)

        //viewmodel

        if (audioFile.exists()) {
            if (audioFile.length() == 0L) {
                checkAudioAction(audioFile)
            } else {
                initMediaPlayer(audioFile)
            }
        } else {
            if (activityViewModel.getExhibitObject().audio != "null") {
                checkAudioAction(audioFile)
            } else {
//                hideAudioControls()

                binding.apply {
                    exhibitPlayerBlock.visibility = View.INVISIBLE
                }
            }
        }
    }

    private fun hideAudioControls() {
        binding.apply {
//            exhibitDurationHolder.visibility = View.GONE
            exhibitPlayerBlock.visibility = View.INVISIBLE
            exhibitNext.visibility = View.INVISIBLE
            exhibitPrevious.visibility = View.INVISIBLE
        }
    }

    private fun initMediaPlayer(file: File) {
        MediaPlayer.initializeMediaPlayer(exhibitActivity, binding, file) {
            binding.apply {
                scope.launch {
                    delay(100)
                    exhibitPlayerProgress.visibility = View.INVISIBLE
                    exhibitProgress.visibility = View.VISIBLE
                    exhibitCurrentTime.visibility = View.VISIBLE
                    exhibitEndTime.visibility = View.VISIBLE
                    exhibitPlay.visibility = View.VISIBLE
                    exhibitPlayRipple.setOnClickListener { MediaPlayer.playAudio(exhibitActivity, binding) }

                    //pause???

                    exhibitPrevious.visibility = View.VISIBLE
                    exhibitPreviousRipple.setOnClickListener { MediaPlayer.playAudio(exhibitActivity, binding) }
                    exhibitNext.visibility = View.VISIBLE
                    exhibitNextRipple.setOnClickListener { MediaPlayer.playAudio(exhibitActivity, binding) }
                }
            }
        }
    }
}