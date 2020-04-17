package com.challenge.lanchonete.menu

import com.challenge.lanchonete.TestData
import com.challenge.lanchonete.menu.list.MenuListViewModel
import com.challenge.lanchonete.rxjava.RxJavaDispatcher
import com.challenge.lanchonete.state.State
import io.mockk.mockk
import io.mockk.verifySequence
import io.reactivex.schedulers.Schedulers
import org.junit.Test

class MenuPresenterTest {

    @Test
    fun `Given sandwiches are going to be loaded When state is updated Then show sandwiches And hide other views`() {
        val viewMock = mockk<MenuView>(relaxed = true)
        val sandwiches = TestData.LIST_OF_SANDWICHES
        val presenter = MenuPresenter(
            viewMock,
            RxJavaDispatcher(Schedulers.trampoline(), Schedulers.trampoline())
        )

        presenter.onStateUpdate(State(State.Name.LOADED, sandwiches))

        verifySequence {
            viewMock.hideErrors()
            viewMock.hideLoading()
            viewMock.showSandwiches(
                MenuListViewModel(
                    sandwiches
                )
            )
        }
    }

    @Test
    fun `Given sandwiches are loading When state is updated Then show loading And hide other views`() {
        val viewMock = mockk<MenuView>(relaxed = true)
        val presenter = MenuPresenter(
            viewMock,
            RxJavaDispatcher(Schedulers.trampoline(), Schedulers.trampoline())
        )

        presenter.onStateUpdate(State(State.Name.LOADING))

        verifySequence {
            viewMock.hideErrors()
            viewMock.hideSandwiches()
            viewMock.showLoading()
        }
    }

    @Test
    fun `Given sandwiches are going to be loaded and the list is empty When state is updated Then show no sandwiches message And hide other views`() {
        val viewMock = mockk<MenuView>(relaxed = true)
        val presenter = MenuPresenter(
            viewMock,
            RxJavaDispatcher(Schedulers.trampoline(), Schedulers.trampoline())
        )

        presenter.onStateUpdate(State(State.Name.LOADED, emptyList()))

        verifySequence {
            viewMock.hideErrors()
            viewMock.hideLoading()
            viewMock.hideSandwiches()
            viewMock.showNoSandwichesError()
        }
    }

    @Test
    fun `Given error while loading sandwiches When state is updated Then show error And hide other views`() {
        val viewMock = mockk<MenuView>(relaxed = true)
        val presenter = MenuPresenter(
            viewMock,
            RxJavaDispatcher(Schedulers.trampoline(), Schedulers.trampoline())
        )

        presenter.onStateUpdate(State(State.Name.ERROR))

        verifySequence {
            viewMock.hideSandwiches()
            viewMock.hideLoading()
            viewMock.showUnknownError()
        }
    }
}
