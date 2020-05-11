package com.challenge.lanchonete.menu

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.challenge.lanchonete.R
import com.challenge.lanchonete.TestActivity
import com.challenge.lanchonete.TestApplication
import com.challenge.lanchonete.TestData
import com.challenge.lanchonete.menu.fakes.FakeMenuManager
import com.challenge.lanchonete.state.State
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(application = TestApplication::class)
class MenuFragmentTest {

    @get:Rule
    val rule: ActivityTestRule<TestActivity> = ActivityTestRule(TestActivity::class.java)

    @Test
    fun `Given loaded sandwiches When view is resumed Then hide loading And hide errors And show list`() {

        rule.activity.testMenuManager =
            FakeMenuManager(
                State(
                    State.Name.LOADED,
                    TestData.LIST_OF_SANDWICHES
                )
            )

        val menuFragment = MenuFragment()
        rule.activity.showFragment(menuFragment)

        onView(withId(R.id.loading)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.errorView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.sandwichList)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun `Given loaded empty list of sandwiches When view is resumed Then hide loading And hide list And show no sandwiches error`() {
        rule.activity.testMenuManager =
            FakeMenuManager(
                State(
                    State.Name.LOADED,
                    emptyList()
                )
            )

        val menuFragment = MenuFragment()
        rule.activity.showFragment(menuFragment)

        onView(withId(R.id.sandwichList)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.loading)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.errorView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun `Given sandwiches list is loading When view is resumed Then show loading And hide other views`() {

        rule.activity.testMenuManager =
            FakeMenuManager(
                State(
                    State.Name.LOADING
                )
            )

        val menuFragment = MenuFragment()
        rule.activity.showFragment(menuFragment)

        onView(withId(R.id.errorView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.sandwichList)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.loading)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun `Given error on getting sandwiches When view is resumed Then hide loading And hide list And show error`() {
        rule.activity.testMenuManager =
            FakeMenuManager(
                State(
                    State.Name.ERROR
                )
            )

        val menuFragment = MenuFragment()
        rule.activity.showFragment(menuFragment)

        onView(withId(R.id.sandwichList)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.loading)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.errorView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun `Given loaded sandwiches When view is resumed Then show the specific sandwich list`() {

        rule.activity.testMenuManager =
            FakeMenuManager(
                State(
                    State.Name.LOADED,
                    TestData.LIST_OF_SANDWICHES
                )
            )

        val menuFragment = MenuFragment()
        rule.activity.showFragment(menuFragment)

        onView(withText("Sand 1")).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
        onView(withText("Sand 2")).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
        onView(withText("Sand 3")).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }
}
