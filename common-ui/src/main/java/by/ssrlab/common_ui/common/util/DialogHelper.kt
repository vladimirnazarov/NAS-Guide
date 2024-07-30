package by.ssrlab.common_ui.common.util

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import by.ssrlab.common_ui.R
import by.ssrlab.common_ui.databinding.DialogLanguageBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val LANGUAGE_DIALOG_DELAY = 250L
private val dialogScope = CoroutineScope(Dispatchers.Main)

fun createSimpleAlertDialog(title: String, message: String, context: Context) {
    MaterialAlertDialogBuilder(context)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton(context.getString(R.string.dialog_ok)) { dialog, _ -> dialog.dismiss() }
        .setCancelable(true)
        .show()
}

//Language Dialog Section
fun createLanguageDialog(
    context: Context,
    sharedPreferences: SharedPreferencesUtils,
    onLanguageChange: () -> Unit
) {
    val dialog = setupDialog(context)
    val dialogBinding = DialogLanguageBinding.inflate(LayoutInflater.from(context))

    dialog.setContentView(dialogBinding.root)
    setupDialogWindow(dialog, context)
    setupLanguageRadioGroup(dialogBinding.dialogLanguageGroup, sharedPreferences, dialog, onLanguageChange)

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

private fun setupLanguageRadioGroup(
    radioGroup: RadioGroup,
    sharedPreferences: SharedPreferencesUtils,
    dialog: Dialog,
    onLanguageChange: () -> Unit
) {
    val currentLanguage = sharedPreferences.getLanguage()
    radioGroup.check(getLanguageRadioButtonId(currentLanguage))

    radioGroup.setOnCheckedChangeListener { _, checkedId ->
        when (checkedId) {
            R.id.dialog_language_en -> dialogScope.launch {
                changeLanguage(currentLanguage, 1, sharedPreferences, dialog, onLanguageChange)
            }
            R.id.dialog_language_be -> dialogScope.launch {
                changeLanguage(currentLanguage, 2, sharedPreferences, dialog, onLanguageChange)
            }
            R.id.dialog_language_ru -> dialogScope.launch {
                changeLanguage(currentLanguage, 3, sharedPreferences, dialog, onLanguageChange)
            }
        }
    }
}

private fun getLanguageRadioButtonId(language: Int): Int {
    return when (language) {
        1 -> R.id.dialog_language_en
        2 -> R.id.dialog_language_be
        3 -> R.id.dialog_language_ru
        else -> R.id.dialog_language_en
    }
}

private suspend fun changeLanguage(
    currentLanguage: Int,
    newLanguage: Int,
    sharedPreferences: SharedPreferencesUtils,
    dialog: Dialog,
    onLanguageChange: () -> Unit
) {
    if (currentLanguage != newLanguage) {
        delay(LANGUAGE_DIALOG_DELAY)
        sharedPreferences.setLanguage(newLanguage)
    }

    dialog.dismiss()
    onLanguageChange()
}