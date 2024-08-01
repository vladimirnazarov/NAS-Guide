package by.ssrlab.nasguide

import android.app.Application
import by.ssrlab.common_ui.R
import by.ssrlab.nasguide.di.appModules
import com.mapbox.navigation.base.options.NavigationOptions
import com.mapbox.navigation.core.lifecycle.MapboxNavigationApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApp)
            modules(appModules)
        }

        if (!MapboxNavigationApp.isSetup()) {
            MapboxNavigationApp.setup {
                NavigationOptions.Builder(this@MainApp)
                    .accessToken(resources.getString(R.string.mapbox_access_token))
                    .build()
            }
        }
    }
}