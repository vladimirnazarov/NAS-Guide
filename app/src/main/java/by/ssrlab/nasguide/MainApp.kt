package by.ssrlab.nasguide

import android.app.Application
import by.ssrlab.ui.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApp)
            modules(listOf(
                uiModule
            ))
        }
    }
}