package by.ssrlab.common_ui.common.util

import android.content.Context
import by.ssrlab.common_ui.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun createSimpleAlertDialog(title: String, message: String, context: Context) {
    MaterialAlertDialogBuilder(context)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton(context.getString(R.string.dialog_ok)) { dialog, _ -> dialog.dismiss() }
        .setCancelable(true)
        .show()
}