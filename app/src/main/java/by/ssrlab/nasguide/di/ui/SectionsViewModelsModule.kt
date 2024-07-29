package by.ssrlab.nasguide.di.ui

import by.ssrlab.ui.vm.FDevelopmentsVM
import by.ssrlab.ui.vm.FOrgsVM
import by.ssrlab.ui.vm.FPlacesVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val sectionsViewModelsModule = module {

    viewModel { FDevelopmentsVM(get(named("network"))) }

    viewModel { FOrgsVM(get(named("network"))) }

    viewModel { FPlacesVM(get(named("network"))) }
}