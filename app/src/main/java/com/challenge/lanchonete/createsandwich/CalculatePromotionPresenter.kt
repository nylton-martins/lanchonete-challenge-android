package com.challenge.lanchonete.createsandwich

import com.challenge.lanchonete.models.Sandwich
import com.challenge.lanchonete.state.Dispatcher
import com.challenge.lanchonete.state.State
import com.challenge.lanchonete.state.StateListener

class CalculatePromotionPresenter(
    private val view: CreateSandwichView,
    private val mainDispatcher: Dispatcher
) : StateListener<Sandwich> {
    override fun onStateUpdate(state: State<Sandwich>) {
        mainDispatcher.dispatch {

            when (state.name) {
                State.Name.LOADED -> {
                    val sandwich = state.value!!
                    view.showPrice(sandwich.price)
                }
            }
        }
    }
}
