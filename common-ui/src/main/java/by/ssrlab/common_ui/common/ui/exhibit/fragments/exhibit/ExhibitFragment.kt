package by.ssrlab.common_ui.common.ui.exhibit.fragments.exhibit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.ssrlab.common_ui.common.ui.base.BaseActivity
import by.ssrlab.common_ui.common.vm.AExhibitVM
import by.ssrlab.common_ui.databinding.FragmentExhibitBinding
import by.ssrlab.data.data.common.RepositoryData
import by.ssrlab.data.data.settings.remote.DevelopmentLocale
import by.ssrlab.data.data.settings.remote.OrganizationLocale
import by.ssrlab.data.data.settings.remote.PersonLocale
import by.ssrlab.data.data.settings.remote.PlaceLocale
import by.ssrlab.data.util.ExhibitObject
import by.ssrlab.domain.utils.fromHtml
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class ExhibitFragment: Fragment() {

    private lateinit var binding: FragmentExhibitBinding
    private val activityViewModel: AExhibitVM by activityViewModel()

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
                exhibitDeveloperTitle.text = (data as DevelopmentLocale).description.departmentFilter.keyName
        }
    }
}