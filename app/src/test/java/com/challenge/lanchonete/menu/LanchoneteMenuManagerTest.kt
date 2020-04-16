package com.challenge.lanchonete.menu

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

class LanchoneteMenuManagerTest {

    @Test
    fun `Given menu gateway returns a list of sandwiches When start is called Then emit loaded state And the list of sandwiches`() {

        val sandwiches = TestData.LIST_OF_SANDWICHES

        val manager = LanchoneteMenuManager(
            RxJavaDispatcher(Schedulers.trampoline(), Schedulers.trampoline()),
            TestMenuGateway(sandwiches),
            FakeErrorFactory()
        )

        val listenerMock = mockk<StateListener<List<Sandwich>>>(relaxed = true)
        manager.registerListener(listenerMock)
        manager.setup()

        verifyOrder {
            listenerMock.onStateUpdate(State(State.Name.IDLE, emptyList()))
            listenerMock.onStateUpdate(State(State.Name.LOADING, emptyList()))
            listenerMock.onStateUpdate(State(State.Name.LOADED, sandwiches))
        }
    }

    @Test
    fun `Given menu gateway returns a list of sandwiches When load sandwiches is called Then emit loaded state And the list of sandwiches`() {
        val sandwiches = TestData.LIST_OF_SANDWICHES

        val manager = LanchoneteMenuManager(
            RxJavaDispatcher(Schedulers.trampoline(), Schedulers.trampoline()),
            TestMenuGateway(sandwiches),
            FakeErrorFactory()
        )

        val listenerMock = mockk<StateListener<List<Sandwich>>>(relaxed = true)
        manager.registerListener(listenerMock)
        manager.setup()
        manager.loadSandwiches()

        verifyOrder {
            listenerMock.onStateUpdate(State(State.Name.IDLE, emptyList()))
            listenerMock.onStateUpdate(State(State.Name.LOADING, emptyList()))
            listenerMock.onStateUpdate(State(State.Name.LOADED, sandwiches))
            listenerMock.onStateUpdate(State(State.Name.LOADING, sandwiches))
            listenerMock.onStateUpdate(State(State.Name.LOADED, sandwiches))
        }
    }

    @Test
    fun `Given menu gateway returns an empty list When start is called Then emit loaded state And the empty list`() {
        val sandwiches = emptyList<Sandwich>()

        val manager = LanchoneteMenuManager(
            RxJavaDispatcher(Schedulers.trampoline(), Schedulers.trampoline()),
            TestMenuGateway(sandwiches),
            FakeErrorFactory()
        )

        val listenerMock = mockk<StateListener<List<Sandwich>>>(relaxed = true)
        manager.registerListener(listenerMock)
        manager.setup()

        verifyOrder {
            listenerMock.onStateUpdate(State(State.Name.IDLE, emptyList()))
            listenerMock.onStateUpdate(State(State.Name.LOADING, emptyList()))
            listenerMock.onStateUpdate(State(State.Name.LOADED, emptyList()))
        }
    }
}
