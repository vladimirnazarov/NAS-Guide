package by.ssrlab.domain.repository.ui

import by.ssrlab.data.obj.DateObject
import by.ssrlab.data.obj.FolderObject
import by.ssrlab.data.obj.GridObject
import by.ssrlab.data.obj.SectionObject
import by.ssrlab.domain.R

class UiDataProvider {

    fun getMainFolders(address1: Int, address2: Int, address3: Int): List<FolderObject> {
        return listOf(
            FolderObject(R.string.folder_history, R.drawable.png_folder_history, address1),
            FolderObject(R.string.folder_organizations, R.drawable.png_folder_orgs, address2),
            FolderObject(R.string.folder_inventions, R.drawable.png_folder_develops, address3)
        )
    }

    fun getHistoryFolders(address1: Int, address2: Int, address3: Int): List<FolderObject> {
        return listOf(
            FolderObject(R.string.folder_dates, R.drawable.png_folder_dates, address1),
            FolderObject(R.string.folder_persons, R.drawable.png_folder_persons, address2),
            FolderObject(R.string.folder_places, R.drawable.png_folder_places, address3)
        )
    }

    fun getSections(): List<SectionObject> {
        return listOf(
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png")
        )
    }

    fun getPlaces(): List<SectionObject> {
        return listOf(
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            SectionObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png")
        )
    }

    fun getPersons(): List<GridObject> {
        return listOf(
            GridObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            GridObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            GridObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            GridObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            GridObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            GridObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            GridObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            GridObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            GridObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png"),
            GridObject("Test", "https://bird-sounds-database.ssrlab.by/media/spectrograms/audio_file.melspectrogram.2024_06_26-05-15-09-665.png")
        )
    }

    fun getDates(): List<DateObject> {
        return listOf(

        )
    }
}