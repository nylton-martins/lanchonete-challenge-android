package com.challenge.lanchonete

import com.challenge.lanchonete.models.Ingredient
import com.challenge.lanchonete.models.Sandwich

class TestData {

    companion object {

        val LIST_OF_INGREDIENTS = mutableListOf(
            Ingredient(
                1,
                "Cheese",
                1.50,
                1
            ),
            Ingredient(
                2,
                "Egg",
                0.80,
                1
            ),
            Ingredient(
                3,
                "Bacon",
                2.00,
                1
            )
        )

        val LIST_OF_SANDWICHES = listOf(
            Sandwich(
                1,
                "Sand 1",
                linkedMapOf(
                    Pair(LIST_OF_INGREDIENTS[0].id, LIST_OF_INGREDIENTS[0]),
                    Pair(LIST_OF_INGREDIENTS[1].id, LIST_OF_INGREDIENTS[1]),
                    Pair(LIST_OF_INGREDIENTS[2].id, LIST_OF_INGREDIENTS[2])
                ),
                3.00
            ),
            Sandwich(
                2,
                "Sand 2",
                linkedMapOf(
                    Pair(LIST_OF_INGREDIENTS[0].id, LIST_OF_INGREDIENTS[0]),
                    Pair(LIST_OF_INGREDIENTS[1].id, LIST_OF_INGREDIENTS[1])
                ),
                4.00
            ),
            Sandwich(
                3,
                "Sand 3",
                linkedMapOf(
                    Pair(LIST_OF_INGREDIENTS[1].id, LIST_OF_INGREDIENTS[1]),
                    Pair(LIST_OF_INGREDIENTS[2].id, LIST_OF_INGREDIENTS[2])
                ),
                5.00
            )
        )
    }
}
