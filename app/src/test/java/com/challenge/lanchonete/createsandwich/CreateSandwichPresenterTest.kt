package com.challenge.lanchonete.createsandwich

import com.challenge.lanchonete.TestData
import com.challenge.lanchonete.rxjava.RxJavaDispatcher
import com.challenge.lanchonete.state.State
import io.mockk.mockk
import io.mockk.verifySequence
import io.reactivex.schedulers.Schedulers
import org.junit.Test

class CreateSandwichPresenterTest {

    @Test
    fun `Given ingredients are going to be loaded When state is updated Then show ingredients And hide other views`() {
        val viewMock = mockk<CreateSandwichView>(relaxed = true)
        val ingredients = TestData.LIST_OF_INGREDIENTS
        val presenter = CreateSandwichPresenter(
            viewMock,
            RxJavaDispatcher(Schedulers.trampoline(), Schedulers.trampoline())
        )

        presenter.onStateUpdate(State(State.Name.LOADED, ingredients))

        verifySequence {
            viewMock.hideErrors()
            viewMock.hideLoading()
            viewMock.showPrice(0.0)
            viewMock.showIngredients(
                ingredients
            )
        }
    }

    @Test
    fun `Given ingredients are loading When state is updated Then show loading And hide other views`() {
        val viewMock = mockk<CreateSandwichView>(relaxed = true)
        val presenter = CreateSandwichPresenter(
            viewMock,
            RxJavaDispatcher(Schedulers.trampoline(), Schedulers.trampoline())
        )

        presenter.onStateUpdate(State(State.Name.LOADING))

        verifySequence {
            viewMock.hideErrors()
            viewMock.hideIngredients()
            viewMock.hidePrice()
            viewMock.showLoading()
        }
    }

    @Test
    fun `Given ingredients are going to be loaded and the list is empty When state is updated Then show no ingredients message And hide other views`() {
        val viewMock = mockk<CreateSandwichView>(relaxed = true)
        val presenter = CreateSandwichPresenter(
            viewMock,
            RxJavaDispatcher(Schedulers.trampoline(), Schedulers.trampoline())
        )

        presenter.onStateUpdate(State(State.Name.LOADED, emptyList()))

        verifySequence {
            viewMock.hideErrors()
            viewMock.hideLoading()
            viewMock.hideIngredients()
            viewMock.hidePrice()
            viewMock.showNoIngredientsError()
        }
    }

    @Test
    fun `Given error while loading ingredients When state is updated Then show error And hide other views`() {
        val viewMock = mockk<CreateSandwichView>(relaxed = true)
        val presenter = CreateSandwichPresenter(
            viewMock,
            RxJavaDispatcher(Schedulers.trampoline(), Schedulers.trampoline())
        )

        presenter.onStateUpdate(State(State.Name.ERROR))

        verifySequence {
            viewMock.hideIngredients()
            viewMock.hideLoading()
            viewMock.hidePrice()
            viewMock.showUnknownError()
        }
    }
}
