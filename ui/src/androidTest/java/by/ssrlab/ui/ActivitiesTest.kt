package by.ssrlab.ui

import android.content.Context
import android.test.mock.MockContext
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import by.ssrlab.common_ui.common.vm.AMainVM
import by.ssrlab.domain.repository.ui.UiDataProvider
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

@RunWith(AndroidJUnit4ClassRunner::class)
class ActivitiesTest {

    private val testUiModule = module {
        single<Context> { MockContext() }
        single { UiDataProvider() }
        viewModel { AMainVM() }
    }

    @Before
    fun startKoinTest() {
        startKoin {
            modules(listOf(testUiModule))
        }
    }

    @After
    fun stopKoinTest() {
        stopKoin()
    }

    @Test
    fun test_isMainActivityInView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main_activity)).check(matches(isDisplayed()))
    }
}