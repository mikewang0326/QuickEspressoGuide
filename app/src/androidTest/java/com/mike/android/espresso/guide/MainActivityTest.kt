package com.mike.android.espresso.guide

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
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
        onView(withId(R.id.greet_button)).perform(click())

        // 3, TextView displays "Hello"
        onView(withId(R.id.greeting)).check(matches(withText(R.string.hello)))
    }
}