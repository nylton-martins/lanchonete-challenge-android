package com.challenge.lanchonete.menu

import com.challenge.lanchonete.models.Sandwich
import com.challenge.lanchonete.state.ErrorFactory
import com.challenge.lanchonete.state.State
import com.challenge.lanchonete.state.StateMachine

abstract class MenuManager(
    errorFactory: ErrorFactory,
    currentState: State<List<Sandwich>>
) : StateMachine<List<Sandwich>>(errorFactory, currentState) {
    abstract fun setup()
    abstract fun loadSandwiches()
}
