package by.ssrlab.common_ui.common.repository

import android.content.Context
import by.ssrlab.common_ui.R
import by.ssrlab.common_ui.common.obj.FolderObject

class UiDataProvider(private val context: Context) {

    fun getMainFolders() = run {
        listOf(
            FolderObject(context.resources.getString(R.string.folder_history), R.drawable.png_history),
            FolderObject(context.resources.getString(R.string.folder_organizations), R.drawable.png_organizations),
            FolderObject(context.resources.getString(R.string.folder_develops), R.drawable.png_develops)
        )
    }
}