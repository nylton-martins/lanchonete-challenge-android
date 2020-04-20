package com.challenge.lanchonete.calculatepromotion

import android.util.Log
import com.challenge.lanchonete.models.Ingredient
import com.challenge.lanchonete.models.Sandwich
import com.challenge.lanchonete.state.Dispatcher
import com.challenge.lanchonete.state.ErrorFactory
import com.challenge.lanchonete.state.State

class LanchonetePromotionManager(
    private val dispatcher: Dispatcher,
    errorFactory: ErrorFactory,
    currentState: State<Sandwich> = State(
        State.Name.IDLE,
        Sandwich(0, "")
    )
) : PromotionManager(errorFactory, currentState) {

    override fun calculateSandwichPrice(ingredient: Ingredient) {
        dispatcher.dispatch({
            moveToLoading()
            if (currentState.value != null) {
                val sandwich = currentState.value as Sandwich
                sandwich.ingredients.add(ingredient)
                sandwich.calculatePrice()

                moveToLoaded(sandwich)
            }
        }, { error ->
            moveToError(error)
            Log.v("TESTE", error.toString())
        })
    }
}
