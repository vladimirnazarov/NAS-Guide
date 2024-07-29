package by.ssrlab.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.ssrlab.common_ui.common.vm.BaseFragmentVM
import by.ssrlab.data.data.PlaceLocale
import by.ssrlab.domain.repository.network.PlacesRepository

class FPlacesVM(placesRepository: PlacesRepository): BaseFragmentVM<PlaceLocale>(placesRepository) {

    private val _placesData = MutableLiveData<List<PlaceLocale>>(listOf())
    val placesData: LiveData<List<PlaceLocale>> get() = _placesData

    private val _title = MutableLiveData("")
    val title: LiveData<String>
        get() = _title

    fun setTitle(value: String) {
        _title.value = value
    }

    init {
        getData {
            _placesData.value = it
        }
    }
}