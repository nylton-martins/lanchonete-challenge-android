package com.challenge.lanchonete

import com.challenge.lanchonete.models.Ingredient
import com.challenge.lanchonete.models.Sandwich

class TestData {

    companion object {

        val LIST_OF_INGREDIENTS = listOf(
            Ingredient(
                1,
                "Cheese",
                1.50f
            ),
            Ingredient(
                2,
                "Egg",
                0.80f
            ),
            Ingredient(
                3,
                "Bacon",
                2.00f
            )
        )

        val LIST_OF_SANDWICHES = listOf(
            Sandwich(
                1,
                LIST_OF_INGREDIENTS,
                3.00f
            ),
            Sandwich(
                2,
                LIST_OF_INGREDIENTS.subList(0, 1),
                4.00f
            ),
            Sandwich(
                3,
                LIST_OF_INGREDIENTS.subList(1, 2),
                5.00f
            )
        )
    }
}
