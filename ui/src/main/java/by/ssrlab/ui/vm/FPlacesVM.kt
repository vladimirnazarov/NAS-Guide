package by.ssrlab.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.ssrlab.common_ui.common.ui.base.vm.BaseFragmentVM
import by.ssrlab.data.data.common.DescriptionData
import by.ssrlab.data.data.settings.remote.PlaceLocale
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

    fun getDescriptionArray(): ArrayList<DescriptionData> {
        val array = arrayListOf<DescriptionData>()
        for (i in _placesData.value!!) {
            array.add(i.description)
        }

        return array
    }

    init {
        getData {
            _placesData.value = it
        }
    }
}