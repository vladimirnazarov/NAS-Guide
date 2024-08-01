package by.ssrlab.common_ui.common.ui.base

import android.content.Context
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatActivity
import by.ssrlab.domain.models.SharedPreferencesUtil
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.Locale

open class BaseActivity: AppCompatActivity(), KoinComponent {

    private fun Context.loadPreferences(): Context {
        val sharedPreferences: SharedPreferencesUtil by inject()

        val locale = Locale(sharedPreferences.getLanguage()!!)
        Locale.setDefault(locale)

        val config = resources.configuration
        config.setLocale(locale)
        config.setLayoutDirection(locale)

        return createConfigurationContext(config)
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ContextWrapper(newBase?.loadPreferences()))
    }

    companion object {
        const val PARCELABLE_DATA = "parcelable_data"
        const val MAPBOX_VIEW_POINT = "mapbox_view_point"
        const val MAPBOX_LOCATION_RECHECK_TIME = 2000L
    }
}