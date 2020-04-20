package com.challenge.lanchonete.calculatepromotion

import com.challenge.lanchonete.models.Ingredient
import com.challenge.lanchonete.models.Sandwich
import com.challenge.lanchonete.state.ErrorFactory
import com.challenge.lanchonete.state.State
import com.challenge.lanchonete.state.StateMachine

abstract class PromotionManager(
    errorFactory: ErrorFactory,
    currentState: State<Sandwich>
) : StateMachine<Sandwich>(errorFactory, currentState) {
    abstract fun calculateSandwichPrice(ingredient: Ingredient)
}
