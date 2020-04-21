package com.challenge.lanchonete.calculatepromotion

import com.challenge.lanchonete.TestData
import com.challenge.lanchonete.models.Sandwich
import com.challenge.lanchonete.rxjava.RxJavaDispatcher
import com.challenge.lanchonete.state.FakeErrorFactory
import com.challenge.lanchonete.state.State
import com.challenge.lanchonete.state.StateListener
import io.mockk.mockk
import io.mockk.verifyOrder
import io.reactivex.schedulers.Schedulers
import org.junit.Test

class LanchonetePromotionManagerTest {

    @Test
    fun `Given a sandwich When calculate price is called Then emit loaded state And the price of the sandwich`() {

        val sandwich = Sandwich(0, "")
        val ingredient = TestData.LIST_OF_INGREDIENTS[0]
        sandwich.ingredients.add(ingredient)
        sandwich.calculatePrice()

        val manager = LanchonetePromotionManager(
            RxJavaDispatcher(Schedulers.trampoline(), Schedulers.trampoline()),
            FakeErrorFactory()
        )

        val listenerMock = mockk<StateListener<Sandwich>>(relaxed = true)
        manager.registerListener(listenerMock)
        manager.calculateSandwichPrice(ingredient)

        verifyOrder {
            listenerMock.onStateUpdate(State(State.Name.IDLE, sandwich))
            listenerMock.onStateUpdate(State(State.Name.LOADING, sandwich))
            listenerMock.onStateUpdate(State(State.Name.LOADED, sandwich))
        }
    }
}
