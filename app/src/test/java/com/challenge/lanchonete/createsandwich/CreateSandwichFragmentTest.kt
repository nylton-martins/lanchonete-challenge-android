package com.challenge.lanchonete.createsandwich

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
import com.challenge.lanchonete.calculatepromotion.fakes.FakePromotionManager
import com.challenge.lanchonete.createsandwich.fakes.FakeCreateSandwichManager
import com.challenge.lanchonete.state.State
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(application = TestApplication::class)
class CreateSandwichFragmentTest {

    @get:Rule
    val rule: ActivityTestRule<TestActivity> = ActivityTestRule(TestActivity::class.java)

    @Test
    fun `Given loaded ingredients When view is resumed Then hide loading And hide errors And show ingredients`() {

        rule.activity.testCreateSandwichManager =
            FakeCreateSandwichManager(
                State(
                    State.Name.LOADED,
                    TestData.LIST_OF_INGREDIENTS
                )
            )

        val createSandwichFragment = CreateSandwichFragment()
        rule.activity.showFragment(createSandwichFragment)

        onView(withId(R.id.loading)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.errorView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.ingredientsList)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
        onView(withId(R.id.priceViews)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun `Given loaded empty list of ingredients When view is resumed Then hide loading And hide list And show no ingredients error`() {
        rule.activity.testCreateSandwichManager =
            FakeCreateSandwichManager(
                State(
                    State.Name.LOADED,
                    emptyList()
                )
            )

        rule.activity.testPromotionManager =
            FakePromotionManager(
                State(
                    State.Name.IDLE
                )
            )

        val createSandwichFragment = CreateSandwichFragment()
        rule.activity.showFragment(createSandwichFragment)

        onView(withId(R.id.ingredientsList)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.loading)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.priceViews)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.errorView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun `Given ingredients list is loading When view is resumed Then show loading And hide other views`() {

        rule.activity.testCreateSandwichManager =
            FakeCreateSandwichManager(
                State(
                    State.Name.LOADING
                )
            )

        rule.activity.testPromotionManager =
            FakePromotionManager(
                State(
                    State.Name.IDLE
                )
            )

        val createSandwichFragment = CreateSandwichFragment()
        rule.activity.showFragment(createSandwichFragment)

        onView(withId(R.id.errorView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.ingredientsList)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.priceViews)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.loading)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun `Given error on getting sandwiches When view is resumed Then hide loading And hide list And show error`() {
        rule.activity.testCreateSandwichManager =
            FakeCreateSandwichManager(
                State(
                    State.Name.ERROR
                )
            )

        rule.activity.testPromotionManager =
            FakePromotionManager(
                State(
                    State.Name.IDLE
                )
            )

        val createSandwichFragment = CreateSandwichFragment()
        rule.activity.showFragment(createSandwichFragment)

        onView(withId(R.id.ingredientsList)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.loading)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.priceViews)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.errorView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun `Given loaded sandwiches When view is resumed Then show the specific sandwich list`() {

        rule.activity.testCreateSandwichManager =
            FakeCreateSandwichManager(
                State(
                    State.Name.LOADED,
                    TestData.LIST_OF_INGREDIENTS
                )
            )

        rule.activity.testPromotionManager =
            FakePromotionManager(
                State(
                    State.Name.IDLE
                )
            )

        val createSandwichFragment = CreateSandwichFragment()
        rule.activity.showFragment(createSandwichFragment)

        onView(withText("Cheese")).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
        onView(withText("Egg")).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
        onView(withText("Bacon")).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }
}
