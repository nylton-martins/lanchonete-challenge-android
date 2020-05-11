package com.challenge.lanchonete.createsandwich.fakes

import com.challenge.lanchonete.createsandwich.gateway.IngredientsGateway
import com.challenge.lanchonete.models.Ingredient

class TestIngredientsGateway(
    private val ingredients: List<Ingredient> = emptyList()
) : IngredientsGateway {

    override fun getAllIngredients(): List<Ingredient> {
        return ingredients
    }
}
