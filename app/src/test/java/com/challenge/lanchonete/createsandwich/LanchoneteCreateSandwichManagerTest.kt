package com.challenge.lanchonete.createsandwich

import com.challenge.lanchonete.TestData
import com.challenge.lanchonete.createsandwich.fakes.TestIngredientsGateway
import com.challenge.lanchonete.models.Ingredient
import com.challenge.lanchonete.rxjava.RxJavaDispatcher
import com.challenge.lanchonete.state.FakeErrorFactory
import com.challenge.lanchonete.state.State
import com.challenge.lanchonete.state.StateListener
import io.mockk.mockk
import io.mockk.verifyOrder
import io.reactivex.schedulers.Schedulers
import org.junit.Test

class LanchoneteCreateSandwichManagerTest {

    @Test
    fun `Given ingredients gateway returns a list of ingredients When start is called Then emit loaded state And the list of ingredients`() {

        val ingredients = TestData.LIST_OF_INGREDIENTS

        val manager = LanchoneteCreateSandwichManager(
            RxJavaDispatcher(Schedulers.trampoline(), Schedulers.trampoline()),
            TestIngredientsGateway(ingredients),
            FakeErrorFactory()
        )

        val listenerMock = mockk<StateListener<List<Ingredient>>>(relaxed = true)
        manager.registerListener(listenerMock)
        manager.loadIngredients()

        verifyOrder {
            listenerMock.onStateUpdate(State(State.Name.IDLE, emptyList()))
            listenerMock.onStateUpdate(State(State.Name.LOADING, emptyList()))
            listenerMock.onStateUpdate(State(State.Name.LOADED, ingredients))
        }
    }

    @Test
    fun `Given ingredients gateway returns a list of ingredients When load ingredients is called twice Then emit loaded state And the list of ingredients`() {
        val ingredients = TestData.LIST_OF_INGREDIENTS

        val manager = LanchoneteCreateSandwichManager(
            RxJavaDispatcher(Schedulers.trampoline(), Schedulers.trampoline()),
            TestIngredientsGateway(ingredients),
            FakeErrorFactory()
        )

        val listenerMock = mockk<StateListener<List<Ingredient>>>(relaxed = true)
        manager.registerListener(listenerMock)
        manager.loadIngredients()
        manager.loadIngredients()

        verifyOrder {
            listenerMock.onStateUpdate(State(State.Name.IDLE, emptyList()))
            listenerMock.onStateUpdate(State(State.Name.LOADING, emptyList()))
            listenerMock.onStateUpdate(State(State.Name.LOADED, ingredients))
            listenerMock.onStateUpdate(State(State.Name.LOADING, ingredients))
            listenerMock.onStateUpdate(State(State.Name.LOADED, ingredients))
        }
    }

    @Test
    fun `Given menu gateway returns an empty list When start is called Then emit loaded state And the empty list`() {
        val ingredients = emptyList<Ingredient>()

        val manager = LanchoneteCreateSandwichManager(
            RxJavaDispatcher(Schedulers.trampoline(), Schedulers.trampoline()),
            TestIngredientsGateway(ingredients),
            FakeErrorFactory()
        )

        val listenerMock = mockk<StateListener<List<Ingredient>>>(relaxed = true)
        manager.registerListener(listenerMock)
        manager.loadIngredients()

        verifyOrder {
            listenerMock.onStateUpdate(State(State.Name.IDLE, emptyList()))
            listenerMock.onStateUpdate(State(State.Name.LOADING, emptyList()))
            listenerMock.onStateUpdate(State(State.Name.LOADED, emptyList()))
        }
    }
}
