package com.challenge.lanchonete

import com.challenge.lanchonete.models.Ingredient
import com.challenge.lanchonete.models.Sandwich

class TestData {

    companion object {

        val LIST_OF_INGREDIENTS = listOf(
            Ingredient(
                1,
                "Cheese",
                1.50
            ),
            Ingredient(
                2,
                "Egg",
                0.80
            ),
            Ingredient(
                3,
                "Bacon",
                2.00
            )
        )

        val LIST_OF_SANDWICHES = listOf(
            Sandwich(
                1,
                "Sand 1",
                LIST_OF_INGREDIENTS,
                3.00
            ),
            Sandwich(
                2,
                "Sand 2",
                LIST_OF_INGREDIENTS.subList(0, 1),
                4.00
            ),
            Sandwich(
                3,
                "Sand 3",
                LIST_OF_INGREDIENTS.subList(1, 2),
                5.00
            )
        )
    }
}
