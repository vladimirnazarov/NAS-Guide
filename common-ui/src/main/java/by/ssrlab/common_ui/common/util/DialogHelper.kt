package by.ssrlab.common_ui.common.util

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import android.widget.ImageSwitcher
import by.ssrlab.common_ui.R
import by.ssrlab.common_ui.common.ui.base.BaseActivity
import by.ssrlab.common_ui.databinding.DialogLanguageBinding
import by.ssrlab.domain.models.SharedPreferencesUtil
import by.ssrlab.domain.utils.transformIntToLanguage
import by.ssrlab.domain.utils.transformLanguageToInt
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Calendar

private const val LANGUAGE_DIALOG_DELAY = 250L
private const val LANGUAGE_EN = 1
private const val LANGUAGE_BE = 2
private const val LANGUAGE_RU = 3

private val dialogScope = CoroutineScope(Dispatchers.Main)
private val calendar = Calendar.getInstance()

//Warning Common
fun createSimpleAlertDialog(title: String, message: String, buttonMessage: String, context: Context) {
    MaterialAlertDialogBuilder(context)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton(buttonMessage) { dialog, _ -> dialog.dismiss() }
        .setCancelable(true)
        .show()
}

//Date
fun createDateDialog(context: Context, onDateChanged: (Int, Int) -> Unit) {
    val datePicker = MaterialDatePicker.Builder.datePicker()
        .setTitleText(context.resources.getString(R.string.choose_date))
        .setSelection(calendar.timeInMillis)
        .setTheme(R.style.CustomDatePickerTheme)
        .build()

    datePicker.addOnPositiveButtonClickListener { selection ->
        calendar.timeInMillis = selection
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        onDateChanged(dayOfMonth, month)
    }

    datePicker.show((context as BaseActivity).supportFragmentManager, "MATERIAL_DATE_PICKER")
}

//Language Dialog Section
fun createLanguageDialog(
    context: Context,
    sharedPreferences: SharedPreferencesUtil,
    onLanguageChange: () -> Unit
) {
    val dialog = setupDialog(context)
    val dialogBinding = DialogLanguageBinding.inflate(LayoutInflater.from(context))

    dialog.setContentView(dialogBinding.root)
    setupDialogWindow(dialog, context)
    setupLanguageSwitchers(dialogBinding, dialog, context, sharedPreferences, onLanguageChange)

    dialog.show()
}

private fun setupDialog(context: Context): Dialog {
    return Dialog(context).apply {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCancelable(true)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}

private fun setupDialogWindow(dialog: Dialog, context: Context) {
    val width = context.resources.displayMetrics.widthPixels
    val layoutParams = WindowManager.LayoutParams().apply {
        copyFrom(dialog.window?.attributes)
        this.width = width - (width / 5)
    }
    dialog.window?.attributes = layoutParams
}

private fun setupLanguageSwitchers(
    dialogBinding: DialogLanguageBinding,
    dialog: Dialog,
    context: Context,
    sharedPreferences: SharedPreferencesUtil,
    onLanguageChange: () -> Unit
) {
    dialogBinding.apply {
        setupSwitcherAnimations(context, dialogLanguageEnSwitcher)
        setupSwitcherAnimations(context, dialogLanguageBeSwitcher)
        setupSwitcherAnimations(context, dialogLanguageRuSwitcher)
    }

    val currentLanguage = sharedPreferences.getLanguage()!!.transformLanguageToInt()
    checkImageByLanguage(currentLanguage, dialogBinding)

    setLanguageButtonClickListener(currentLanguage, dialogBinding, dialog, sharedPreferences, onLanguageChange)
}

private fun setupSwitcherAnimations(context: Context, dialogSwitcher: ImageSwitcher) {
    val switcherIn = R.anim.dialog_switcher_in
    val switcherOut = R.anim.dialog_switcher_out

    dialogSwitcher.setInAnimation(context, switcherIn)
    dialogSwitcher.setOutAnimation(context, switcherOut)
}

private fun setLanguageButtonClickListener(
    currentLanguage:Int,
    dialogBinding: DialogLanguageBinding,
    dialog: Dialog,
    sharedPreferences: SharedPreferencesUtil,
    onLanguageChange: () -> Unit
) {
    dialogBinding.dialogLanguageEn.setOnClickListener { handleLanguageChange(dialog, LANGUAGE_EN, currentLanguage, dialogBinding, sharedPreferences, onLanguageChange) }
    dialogBinding.dialogLanguageBe.setOnClickListener { handleLanguageChange(dialog, LANGUAGE_BE, currentLanguage, dialogBinding, sharedPreferences, onLanguageChange) }
    dialogBinding.dialogLanguageRu.setOnClickListener { handleLanguageChange(dialog, LANGUAGE_RU, currentLanguage, dialogBinding, sharedPreferences, onLanguageChange) }
}

private fun handleLanguageChange(
    dialog: Dialog,
    newLanguage: Int,
    currentLanguage: Int,
    dialogBinding: DialogLanguageBinding,
    sharedPreferences: SharedPreferencesUtil,
    onLanguageChange: () -> Unit
) {
    if (currentLanguage != newLanguage) {
        checkImageByLanguage(newLanguage, dialogBinding)
        changeLanguage(newLanguage, dialog, sharedPreferences, onLanguageChange)
        disableButtons(dialogBinding)
    }
}

private fun checkImageByLanguage(language: Int, dialogBinding: DialogLanguageBinding) {
    val checkedDrawable = R.drawable.ic_radio_button_checked
    val uncheckedDrawable = R.drawable.ic_radio_button_unchecked

    dialogBinding.apply {
        dialogLanguageEnSwitcher.setImageResource(if (language == LANGUAGE_EN) checkedDrawable else uncheckedDrawable)
        dialogLanguageBeSwitcher.setImageResource(if (language == LANGUAGE_BE) checkedDrawable else uncheckedDrawable)
        dialogLanguageRuSwitcher.setImageResource(if (language == LANGUAGE_RU) checkedDrawable else uncheckedDrawable)
    }
}

private fun changeLanguage(
    newLanguage: Int,
    dialog: Dialog,
    sharedPreferences: SharedPreferencesUtil,
    onLanguageChange: () -> Unit
) {
    dialogScope.launch {
        sharedPreferences.setLanguage(newLanguage.transformIntToLanguage())
        delay(LANGUAGE_DIALOG_DELAY)
        dialog.dismiss()
        onLanguageChange()
    }
}

private fun disableButtons(dialogBinding: DialogLanguageBinding) {
    dialogBinding.apply {
        dialogLanguageEn.isClickable = false
        dialogLanguageBe.isClickable = false
        dialogLanguageRu.isClickable = false
    }
}