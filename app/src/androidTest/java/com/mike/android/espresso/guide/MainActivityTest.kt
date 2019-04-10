package com.mike.android.espresso.guide

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.Toolbar
import android.view.View
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule @JvmField
    var activityRule = ActivityTestRule<MainActivity> (MainActivity::class.java)

    @Test
    fun greet() {
        // 1, TextView is empty
        onView(withId(R.id.greeting)).check(matches(withText("")))

        // 2, Click the button
        onView(withId(R.id.greet_button)).perform(click()).check(matches(not(isEnabled())))

        // 3, TextView displays "Hello"
        onView(withId(R.id.greeting)).check(matches(withText(R.string.hello)))
    }

    @Test
    fun toolbarTitle() {
        val title = InstrumentationRegistry.getTargetContext().getString(R.string.title)
        onView(isAssignableFrom(Toolbar::class.java))
                .check(matches(withToolbarTitle(title)))
    }

    private fun withToolbarTitle(expectedTitle: CharSequence): Matcher<View> {
        return object : BoundedMatcher<View, Toolbar>(Toolbar::class.java) {
            override fun describeTo(description: Description?) {
                description?.appendText("with toolbar title: " + expectedTitle)
            }

            override fun matchesSafely(toolbar: Toolbar?): Boolean {
                return expectedTitle == toolbar?.title
            }
        }

    }

    @Test
    fun clickItem() {
        onView(withId(R.id.footer))
                .check(matches(not(isDisplayed())))

        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition<NumberAdapter
        .TextViewHolder>(12, click()))

        onView(withId(R.id.footer))
                .check(matches(withText("12")))
                .check(matches(isDisplayed()))
    }

}