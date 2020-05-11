package com.challenge.lanchonete.createsandwich

import com.challenge.lanchonete.models.Ingredient
import com.challenge.lanchonete.state.ErrorFactory
import com.challenge.lanchonete.state.State
import com.challenge.lanchonete.state.StateMachine

abstract class CreateSandwichManager(
    errorFactory: ErrorFactory,
    currentState: State<List<Ingredient>>
) : StateMachine<List<Ingredient>>(errorFactory, currentState) {
    abstract fun loadIngredients()
}
