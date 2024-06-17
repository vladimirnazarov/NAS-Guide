package by.ssrlab.ui.repository

import android.content.Context
import by.ssrlab.common_ui.R
import by.ssrlab.common_ui.common.obj.FolderObject

class UiDataProvider(private val context: Context) {

    fun getMainFolders(): List<FolderObject> {
        return listOf(
            FolderObject(context.resources.getString(R.string.folder_history), R.drawable.png_history, by.ssrlab.ui.R.id.action_mainFragment_to_historyFragment),
            FolderObject(context.resources.getString(R.string.folder_organizations), R.drawable.png_organizations, by.ssrlab.ui.R.id.action_mainFragment_to_orgFragment),
            FolderObject(context.resources.getString(R.string.folder_develops), R.drawable.png_develops, by.ssrlab.ui.R.id.action_mainFragment_to_inventionsFragment)
        )
    }
}