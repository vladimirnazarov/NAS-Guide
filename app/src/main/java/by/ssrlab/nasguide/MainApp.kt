package by.ssrlab.nasguide

import android.app.Application
import by.ssrlab.nasguide.di.ui.commonUiModule
import by.ssrlab.nasguide.di.ui.domainModule
import by.ssrlab.nasguide.di.networkModule
import by.ssrlab.nasguide.di.repositoriesModule
import by.ssrlab.nasguide.di.ui.sectionsViewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApp)
            modules(listOf(
                domainModule,
                commonUiModule,
                networkModule,
                repositoriesModule,
                sectionsViewModelsModule
            ))
        }
    }
}