package by.ssrlab.ui.di

import by.ssrlab.ui.repository.UiDataProvider
import by.ssrlab.common_ui.common.vm.AMainVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    single { UiDataProvider(get()) }
    viewModel { AMainVM(get()) }
}