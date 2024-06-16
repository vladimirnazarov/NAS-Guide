package by.ssrlab.common_ui.common.repository

import android.content.Context
import by.ssrlab.common_ui.R
import by.ssrlab.common_ui.common.obj.FolderObject

class ProvideUiData(private val context: Context) {

    fun getMainFolders() = run {
        listOf(
            FolderObject(context.resources.getString(), R.drawable.),
            FolderObject(context.resources.getString(), R.drawable.),
            FolderObject(context.resources.getString(), R.drawable.)
        )
    }
}