package com.challenge.lanchonete.menu

import android.util.Log
import com.challenge.lanchonete.menu.gateway.MenuGateway
import com.challenge.lanchonete.models.Sandwich
import com.challenge.lanchonete.state.Dispatcher
import com.challenge.lanchonete.state.ErrorFactory
import com.challenge.lanchonete.state.State

class LanchoneteMenuManager(
    private val dispatcher: Dispatcher,
    private val menuGateway: MenuGateway,
    errorFactory: ErrorFactory,
    currentState: State<List<Sandwich>> = State(
        State.Name.IDLE,
        emptyList()
    )
) : MenuManager(errorFactory, currentState) {

    override fun setup() {
        loadSandwiches()
    }

    override fun loadSandwiches() {
        dispatcher.dispatch({
            moveToLoading()
            val sandwiches = menuGateway.getAllSandwiches()
            moveToLoaded(sandwiches)
        }, { error ->
            moveToError(error)
            Log.v("TESTE", error.toString())
        })
    }
}
