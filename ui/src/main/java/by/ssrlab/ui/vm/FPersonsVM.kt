package by.ssrlab.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.ssrlab.common_ui.common.ui.base.vm.BaseFragmentVM
import by.ssrlab.data.data.settings.remote.PersonLocale
import by.ssrlab.domain.repository.network.PersonsRepository

class FPersonsVM(personsRepository: PersonsRepository): BaseFragmentVM<PersonLocale>(personsRepository) {

    private val _personsData = MutableLiveData<List<PersonLocale>>(listOf())
    val personsData: LiveData<List<PersonLocale>> get() = _personsData

    private val _title = MutableLiveData("")
    val title: LiveData<String>
        get() = _title

    fun setTitle(value: String) {
        _title.value = value
    }

    init {
        getData {
            _personsData.value = it
        }
    }
}