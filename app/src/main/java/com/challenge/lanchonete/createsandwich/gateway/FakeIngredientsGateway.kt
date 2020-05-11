package com.challenge.lanchonete.createsandwich.gateway

import com.challenge.lanchonete.models.Ingredient

class FakeIngredientsGateway : IngredientsGateway {
    override fun getAllIngredients(): List<Ingredient> {
        val ingredients = mutableListOf<Ingredient>()

        val cheese = Ingredient(1, "Cheese", 1.50)
        val egg = Ingredient(2, "Egg", 0.8)
        val meatHamburger = Ingredient(3, "Meat Hamburger", 3.0)
        val bacon = Ingredient(4, "Bacon", 2.0)
        val lettuce = Ingredient(5, "Lettuce", 0.4)

        ingredients.add(cheese)
        ingredients.add(egg)
        ingredients.add(meatHamburger)
        ingredients.add(bacon)
        ingredients.add(lettuce)

        return ingredients
    }
}
