package by.ssrlab.common_ui.common.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.ssrlab.common_ui.R
import by.ssrlab.common_ui.common.ui.base.BaseActivity
import by.ssrlab.data.util.ButtonAction
import by.ssrlab.domain.models.ToolbarControlObject
import java.time.LocalDate
import java.time.Month

class AMainVM: ViewModel() {

    private val _headerImg = MutableLiveData(0)
    val headerImg: LiveData<Int>
        get() = _headerImg

    fun setHeaderImg(resource: Int) {
        _headerImg.value = resource
    }

    //Control buttons
    private val _isBackVisible = MutableLiveData(false)
    private val _isLangVisible = MutableLiveData(false)
    private val _isSearchVisible = MutableLiveData(false)
    private val _isDatesVisible = MutableLiveData(false)

    val isBackVisible: LiveData<Boolean> get() = _isBackVisible
    val isLangVisible: LiveData<Boolean> get() = _isLangVisible
    val isSearchVisible: LiveData<Boolean> get() = _isSearchVisible
    val isDatesVisible: LiveData<Boolean> get() = _isDatesVisible

    fun setupButtons(toolbarControlObject: ToolbarControlObject) {
        _isBackVisible.value = toolbarControlObject.isBack
        _isLangVisible.value = toolbarControlObject.isLang
        _isSearchVisible.value = toolbarControlObject.isSearch
        _isDatesVisible.value = toolbarControlObject.isDates
    }

    private val _backAction = MutableLiveData<() -> Unit>(::emptyAction)
    private val _searchAction = MutableLiveData<() -> Unit>(::emptyAction)
    private val _chooseDateAction = MutableLiveData<() -> Unit>(::emptyAction)
    private val _languageAction = MutableLiveData<() -> Unit>(::emptyAction)

    val backAction: LiveData<() -> Unit> get() = _backAction
    val searchAction: LiveData<() -> Unit> get() = _searchAction
    val chooseDateAction: LiveData<() -> Unit> get() = _chooseDateAction
    val languageAction: LiveData<() -> Unit> get() = _languageAction

    fun setButtonAction(buttonAction: ButtonAction, action: () -> Unit) {
        when (buttonAction) {
            ButtonAction.BackAction -> _backAction.value = action
            ButtonAction.ChooseDateAction -> _searchAction.value = action
            ButtonAction.SearchAction -> _chooseDateAction.value = action
            ButtonAction.LanguageAction -> _languageAction.value = action
        }
    }

    private fun emptyAction() {}

    //Date section
    private val _currentDateTime = MutableLiveData("")
    val currentDateTime: LiveData<String> get() = _currentDateTime

    fun setCurrentDate(activity: BaseActivity) {
        val currentDate = LocalDate.now()
        val currentDay = currentDate.dayOfMonth.toString()
        val currentMonth = currentDate.month

        _currentDateTime.value = "$currentDay ${formatMonth(currentMonth, activity)}"
    }

    private fun formatMonth(month: Month, activity: BaseActivity): String {
        return when (month) {
            Month.JANUARY -> activity.resources.getString(R.string.january)
            Month.FEBRUARY -> activity.resources.getString(R.string.february)
            Month.MARCH -> activity.resources.getString(R.string.march)
            Month.APRIL -> activity.resources.getString(R.string.april)
            Month.MAY -> activity.resources.getString(R.string.may)
            Month.JUNE -> activity.resources.getString(R.string.june)
            Month.JULY -> activity.resources.getString(R.string.july)
            Month.AUGUST -> activity.resources.getString(R.string.august)
            Month.SEPTEMBER -> activity.resources.getString(R.string.september)
            Month.OCTOBER -> activity.resources.getString(R.string.october)
            Month.NOVEMBER -> activity.resources.getString(R.string.november)
            Month.DECEMBER -> activity.resources.getString(R.string.december)
        }
    }
}