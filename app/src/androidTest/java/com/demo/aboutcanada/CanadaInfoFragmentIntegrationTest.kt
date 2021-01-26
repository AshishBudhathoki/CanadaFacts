package com.demo.aboutcanada

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.swipeDown
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.demo.aboutcanada.features.canadaInfo.CanadaInfoActivity
import com.demo.aboutcanada.features.canadaInfo.CanadaInfoAdapter
import com.demo.aboutcanada.features.canadaInfo.CanadaInfoFragment
import org.hamcrest.Matcher
import org.junit.*
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
internal class CanadaInfoFragmentIntegrationTest : BaseTest() {

    private lateinit var appContext: Context

    @get:Rule
    val intentsTestRule = IntentsTestRule(CanadaInfoActivity::class.java)

    @Before
    override fun setup() {
        super.setup()
        appContext = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @After
    override fun tearDown() {
        super.tearDown()
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.demo.aboutcanada", appContext.packageName)
    }

    @Test
    fun checkToolbarTitle() {
        sleep()
        initiateScenario()
        Espresso.onView(withId(R.id.toolbarTitle)).check(matches(withText(R.string.toolbar_title)))
    }


    @Test
    fun performScrolling() {
        sleep()
        initiateScenario()
        // First, scroll to the view holder using the isInTheMiddle() matcher.
        Espresso.onView(withId(R.id.rvCanadaInfo))
            .perform(
                RecyclerViewActions.scrollToPosition<CanadaInfoAdapter.ViewHolder>(
                    10
                )
            )
        sleep()
    }

    @Test
    fun shouldDisplayRecyclerView() {
        sleep()
        initiateScenario()
        Espresso.onView(withId(R.id.rvCanadaInfo))
            .check(matches(withChild(isDisplayed())))
        sleep()
    }

    @Test
    fun shouldDisplayErrorView() {
        sleep()
        Espresso.onView(withId(R.id.swipeRepoRefresh))
            .perform(
                withCustomConstraints(
                    swipeDown(),
                    isDisplayingAtLeast(85)
                )
            )
        sleep()
    }

    @Test
    fun forceRefreshRepositories() {
        initiateScenario()
        Espresso.onView(withId(R.id.swipeRepoRefresh))
            .perform(
                withCustomConstraints(
                    swipeDown(),
                    isDisplayingAtLeast(85)
                )
            )
        sleep()
    }

    private fun initiateScenario() {
        launchFragmentInContainer(Bundle(), R.style.Theme_MaterialComponents) {
            CanadaInfoFragment()
        }
    }

    private fun withCustomConstraints(
        action: ViewAction, constraints: Matcher<View?>?
    ): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View?>? {
                return constraints
            }

            override fun getDescription(): String? {
                return action.description
            }

            override fun perform(
                uiController: UiController?,
                view: View?
            ) {
                action.perform(uiController, view)
            }
        }
    }
}