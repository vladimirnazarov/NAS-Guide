package by.ssrlab.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.ssrlab.common_ui.common.ui.base.vm.BaseFragmentVM
import by.ssrlab.data.data.settings.remote.OrganizationLocale
import by.ssrlab.domain.repository.network.OrgsRepository

class FOrgsVM(orgsRepository: OrgsRepository): BaseFragmentVM<OrganizationLocale>(orgsRepository) {

    private val _orgsData = MutableLiveData<List<OrganizationLocale>>(listOf())
    val orgsData: LiveData<List<OrganizationLocale>> get() = _orgsData

    private val _title = MutableLiveData("")
    val title: LiveData<String>
        get() = _title

    fun setTitle(value: String) {
        _title.value = value
    }

    init {
        getData {
            _orgsData.value = it
        }
    }
}