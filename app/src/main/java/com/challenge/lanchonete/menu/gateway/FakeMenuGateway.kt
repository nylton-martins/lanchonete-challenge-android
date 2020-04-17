package com.challenge.lanchonete.menu.gateway

import com.challenge.lanchonete.models.Ingredient
import com.challenge.lanchonete.models.Sandwich

class FakeMenuGateway : MenuGateway {
    override fun getAllSandwiches(): List<Sandwich> {
        val sandwiches = mutableListOf<Sandwich>()

        val cheese = Ingredient(1, "Cheese", 1.50)
        val egg = Ingredient(2, "Egg", 0.8)
        val meatHamburger = Ingredient(3, "Meat Hamburger", 3.0)
        val bacon = Ingredient(4, "Bacon", 2.0)
        val lettuce = Ingredient(5, "Lettuce", 0.4)

        val xBacon = Sandwich(1, "X-Bacon", listOf(bacon, meatHamburger, cheese), 1.0)
        val xBurger = Sandwich(2, "X-Burger", listOf(meatHamburger, cheese), 1.0)
        val xEgg = Sandwich(3, "X-Egg", listOf(egg, meatHamburger, cheese), 1.0)
        val xEggBacon = Sandwich(4, "X-Egg Bacon", listOf(egg, bacon, meatHamburger, cheese), 1.0)
        sandwiches.add(xBacon)
        sandwiches.add(xBurger)
        sandwiches.add(xEgg)
        sandwiches.add(xEggBacon)

        return sandwiches
    }
}
