package com.challenge.lanchonete.menu.fakes

import com.challenge.lanchonete.menu.MenuManager
import com.challenge.lanchonete.models.Sandwich
import com.challenge.lanchonete.state.FakeErrorFactory
import com.challenge.lanchonete.state.State

class FakeMenuManager(
    currentState: State<List<Sandwich>> = State(State.Name.LOADED, emptyList()),
    private val sandwichList: List<Sandwich> = emptyList()
) :
    MenuManager(
        FakeErrorFactory(),
        currentState
    ) {

    override fun loadSandwiches() {
        moveToLoaded(sandwichList)
    }

    override fun setup() {
    }
}
