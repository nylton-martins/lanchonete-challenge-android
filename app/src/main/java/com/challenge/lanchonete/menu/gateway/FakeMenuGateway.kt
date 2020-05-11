package com.challenge.lanchonete.menu.gateway

import com.challenge.lanchonete.models.Ingredient
import com.challenge.lanchonete.models.Sandwich

class FakeMenuGateway : MenuGateway {
    override fun getAllSandwiches(): List<Sandwich> {
        val sandwiches = mutableListOf<Sandwich>()

        val cheese = Ingredient(1, "Cheese", 1.50, 1)
        val egg = Ingredient(2, "Egg", 0.8, 1)
        val meatHamburger = Ingredient(3, "Meat Hamburger", 3.0, 1)
        val bacon = Ingredient(4, "Bacon", 2.0, 1)

        val xBacon = Sandwich(1, "X-Bacon", linkedMapOf(Pair(bacon.id, bacon), Pair(meatHamburger.id, meatHamburger), Pair(cheese.id, cheese)))
        xBacon.calculatePrice()
        val xBurger = Sandwich(2, "X-Burger", linkedMapOf(Pair(meatHamburger.id, meatHamburger), Pair(cheese.id, cheese)))
        xBurger.calculatePrice()
        val xEgg = Sandwich(3, "X-Egg", linkedMapOf(Pair(egg.id, egg), Pair(meatHamburger.id, meatHamburger), Pair(cheese.id, cheese)))
        xEgg.calculatePrice()
        val xEggBacon = Sandwich(4, "X-Egg Bacon", linkedMapOf(Pair(egg.id, egg), Pair(bacon.id, bacon), Pair(meatHamburger.id, meatHamburger), Pair(cheese.id, cheese)))
        xEggBacon.calculatePrice()
        sandwiches.add(xBacon)
        sandwiches.add(xBurger)
        sandwiches.add(xEgg)
        sandwiches.add(xEggBacon)

        return sandwiches
    }
}
