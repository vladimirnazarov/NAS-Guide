package by.ssrlab.ui.repository

import by.ssrlab.common_ui.R
import by.ssrlab.common_ui.common.obj.FolderObject
import by.ssrlab.common_ui.common.obj.SectionObject

open class UiDataProvider {

    fun getMainFolders(): List<FolderObject> {
        return listOf(
            FolderObject(R.string.folder_history, R.drawable.png_folder_history, by.ssrlab.ui.R.id.action_mainFragment_to_historyFragment),
            FolderObject(R.string.folder_organizations, R.drawable.png_folder_orgs, by.ssrlab.ui.R.id.action_mainFragment_to_orgFragment),
            FolderObject(R.string.folder_inventions, R.drawable.png_folder_develops, by.ssrlab.ui.R.id.action_mainFragment_to_inventionsFragment)
        )
    }

    fun getHistoryFolders(): List<FolderObject> {
        return listOf(
            FolderObject(R.string.folder_dates, R.drawable.png_folder_dates, by.ssrlab.ui.R.id.action_historyFragment_to_datesFragment),
            FolderObject(R.string.folder_persons, R.drawable.png_folder_persons, by.ssrlab.ui.R.id.action_historyFragment_to_personsFragment),
            FolderObject(R.string.folder_places, R.drawable.png_folder_places, by.ssrlab.ui.R.id.action_historyFragment_to_placesFragment)
        )
    }

    open fun getSections(): List<SectionObject> {
        return listOf(
            SectionObject("Test", "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/144694078/original/42073354247a976027d92a56ded126bc59235d60/send-you-a-random-png.png", 0),
            SectionObject("Test", "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/144694078/original/42073354247a976027d92a56ded126bc59235d60/send-you-a-random-png.png", 0),
            SectionObject("Test", "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/144694078/original/42073354247a976027d92a56ded126bc59235d60/send-you-a-random-png.png", 0),
            SectionObject("Test", "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/144694078/original/42073354247a976027d92a56ded126bc59235d60/send-you-a-random-png.png", 0),
            SectionObject("Test", "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/144694078/original/42073354247a976027d92a56ded126bc59235d60/send-you-a-random-png.png", 0),
            SectionObject("Test", "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/144694078/original/42073354247a976027d92a56ded126bc59235d60/send-you-a-random-png.png", 0),
            SectionObject("Test", "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/144694078/original/42073354247a976027d92a56ded126bc59235d60/send-you-a-random-png.png", 0),
            SectionObject("Test", "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/144694078/original/42073354247a976027d92a56ded126bc59235d60/send-you-a-random-png.png", 0),
            SectionObject("Test", "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/144694078/original/42073354247a976027d92a56ded126bc59235d60/send-you-a-random-png.png", 0),
            SectionObject("Test", "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/144694078/original/42073354247a976027d92a56ded126bc59235d60/send-you-a-random-png.png", 0),
            SectionObject("Test", "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/144694078/original/42073354247a976027d92a56ded126bc59235d60/send-you-a-random-png.png", 0)
        )
    }
}