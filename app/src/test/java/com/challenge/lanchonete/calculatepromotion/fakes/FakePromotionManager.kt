package com.challenge.lanchonete.calculatepromotion.fakes

import com.challenge.lanchonete.calculatepromotion.PromotionManager
import com.challenge.lanchonete.models.Ingredient
import com.challenge.lanchonete.models.Sandwich
import com.challenge.lanchonete.state.FakeErrorFactory
import com.challenge.lanchonete.state.State

class FakePromotionManager(
    currentState: State<Sandwich> = State(State.Name.LOADED, Sandwich(0, "")),
    private val sandwich: Sandwich = Sandwich(0, "", mutableListOf(), 5.0)
) :
    PromotionManager(
        FakeErrorFactory(),
        currentState
    ) {

    override fun calculateSandwichPrice(ingredient: Ingredient) {
        moveToLoaded(sandwich)
    }
}
