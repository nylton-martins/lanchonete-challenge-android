package com.challenge.lanchonete.menu.gateway

import com.challenge.lanchonete.models.Ingredient
import com.challenge.lanchonete.models.Sandwich

class FakeMenuGateway : MenuGateway {
    override fun getAllSandwiches(): List<Sandwich> {
        val sandwiches = mutableListOf<Sandwich>()

        val cheese = Ingredient(1, "cheese", 1.0)
        val sandwich = Sandwich(1, listOf(cheese), 1.0)
        sandwiches.add(sandwich)

        return sandwiches
    }
}
