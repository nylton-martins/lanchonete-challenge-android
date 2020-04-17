package com.challenge.lanchonete.createsandwich

import android.util.Log
import com.challenge.lanchonete.createsandwich.gateway.IngredientsGateway
import com.challenge.lanchonete.models.Ingredient
import com.challenge.lanchonete.state.Dispatcher
import com.challenge.lanchonete.state.ErrorFactory
import com.challenge.lanchonete.state.State

class LanchoneteCreateSandwichManager(
    private val dispatcher: Dispatcher,
    private val ingredientsGateway: IngredientsGateway,
    errorFactory: ErrorFactory,
    currentState: State<List<Ingredient>> = State(
        State.Name.IDLE,
        emptyList()
    )
) : CreateSandwichManager(errorFactory, currentState) {

    override fun loadIngredients() {
        dispatcher.dispatch({
            moveToLoading()
            val ingredients = ingredientsGateway.getAllIngredients()
            moveToLoaded(ingredients)
        }, { error ->
            moveToError(error)
            Log.v("TESTE", error.toString())
        })
    }
}
