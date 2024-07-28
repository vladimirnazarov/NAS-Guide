package by.ssrlab.ui

import android.content.Context
import android.test.mock.MockContext
import androidx.fragment.app.testing.FragmentScenario
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import by.ssrlab.ui.fragments.MainFragment
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import by.ssrlab.common_ui.common.vm.AMainVM
import by.ssrlab.domain.repository.ui.UiDataProvider
import org.junit.After
import org.junit.Before
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

@RunWith(AndroidJUnit4ClassRunner::class)
class FragmentMainTest {

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
    fun test_mainFragment() {
        val fragmentScenario = FragmentScenario.launch(MainFragment::class.java)
        onView(withId(R.id.main_title)).check(matches(withText("abc")))
    }
}