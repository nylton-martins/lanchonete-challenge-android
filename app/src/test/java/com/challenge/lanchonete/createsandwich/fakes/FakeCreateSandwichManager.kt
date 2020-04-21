package com.challenge.lanchonete.createsandwich.fakes

import com.challenge.lanchonete.createsandwich.CreateSandwichManager
import com.challenge.lanchonete.models.Ingredient
import com.challenge.lanchonete.state.FakeErrorFactory
import com.challenge.lanchonete.state.State

class FakeCreateSandwichManager(
    currentState: State<List<Ingredient>> = State(State.Name.LOADED, emptyList()),
    private val ingredients: List<Ingredient> = emptyList()
) :
    CreateSandwichManager(
        FakeErrorFactory(),
        currentState
    ) {

    override fun loadIngredients() {
        moveToLoaded(ingredients)
    }
}
