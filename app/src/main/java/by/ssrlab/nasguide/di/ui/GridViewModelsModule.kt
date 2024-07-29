package by.ssrlab.nasguide.di.ui

import by.ssrlab.ui.vm.FPersonsVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val gridViewModelsModule = module {

    viewModel { FPersonsVM(get(named("network"))) }
}