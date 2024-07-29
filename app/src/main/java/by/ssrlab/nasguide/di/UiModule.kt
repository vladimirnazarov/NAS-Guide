package by.ssrlab.nasguide.di

import by.ssrlab.nasguide.di.ui.commonUiModule
import by.ssrlab.nasguide.di.ui.gridViewModelsModule
import by.ssrlab.nasguide.di.ui.sectionsViewModelsModule
import by.ssrlab.nasguide.di.ui.uiProviderModule

val uiModule = commonUiModule + uiProviderModule + gridViewModelsModule + sectionsViewModelsModule