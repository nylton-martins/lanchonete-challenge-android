package com.challenge.lanchonete

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EndToEndTest {

    @get:Rule
    val rule: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun givenLoadedMoviesWhenMovieIsClickedThenShouldDisplayMovieDetails() {

        rule.launchActivity(Intent())

        Thread.sleep(2000)

        onView(withId(R.id.createSandwichButton)).perform(click())

        onView(withId(R.id.priceViews)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }
}
