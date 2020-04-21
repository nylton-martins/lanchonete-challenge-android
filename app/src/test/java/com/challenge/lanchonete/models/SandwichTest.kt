package com.challenge.lanchonete.models

import junit.framework.TestCase.assertEquals
import org.junit.Test

class SandwichTest {

    @Test
    fun `Given a sandwich model with ingredients When calculate price is invoked and there is no promotion Then calculate the right price`() {
        val sandwich = Sandwich(0, "")

        sandwich.ingredients.add(Ingredient(0, "Cheese", 1.5))
        sandwich.ingredients.add(Ingredient(0, "Meat Hamburger", 1.0))
        sandwich.ingredients.add(Ingredient(0, "Egg", 2.0))
        sandwich.calculatePrice()

        val expected = 1.5 + 1.0 + 2.0

        assertEquals(expected, sandwich.price)
    }

    @Test
    fun `Given a sandwich model with ingredients When calculate price is invoked and there is light promotion Then calculate the right price`() {
        val sandwich = Sandwich(0, "")

        sandwich.ingredients.add(Ingredient(0, "Cheese", 1.5))
        sandwich.ingredients.add(Ingredient(0, "Meat Hamburger", 1.0))
        sandwich.ingredients.add(Ingredient(0, "Egg", 2.0))
        sandwich.ingredients.add(Ingredient(0, "Lettuce", 2.0))
        sandwich.calculatePrice()

        val price = 1.5 + 1.0 + 2.0 + 2.0
        val expected = price - (price * 0.1)

        assertEquals(expected, sandwich.price)
    }

    @Test
    fun `Given a sandwich model with ingredients When calculate price is invoked and there is meat promotion Then calculate the right price`() {
        val sandwich = Sandwich(0, "")

        sandwich.ingredients.add(Ingredient(0, "Cheese", 1.5))
        sandwich.ingredients.add(Ingredient(0, "Meat Hamburger", 2.0))
        sandwich.ingredients.add(Ingredient(0, "Meat Hamburger", 2.0))
        sandwich.ingredients.add(Ingredient(0, "Meat Hamburger", 2.0))
        sandwich.calculatePrice()

        val expected = 1.5 + 2.0 + 2.0

        assertEquals(expected, sandwich.price)
    }

    @Test
    fun `Given a sandwich model with ingredients When calculate price is invoked and there is two promotion Then use the better promotion And calculate the right price`() {
        val sandwich = Sandwich(0, "")

        sandwich.ingredients.add(Ingredient(0, "Cheese", 1.5))
        sandwich.ingredients.add(Ingredient(0, "Meat Hamburger", 2.0))
        sandwich.ingredients.add(Ingredient(0, "Meat Hamburger", 2.0))
        sandwich.ingredients.add(Ingredient(0, "Meat Hamburger", 2.0))
        sandwich.ingredients.add(Ingredient(0, "Lettuce", 1.0))
        sandwich.calculatePrice()

        // One hamburger for free is better than 10% discount
        val expected = 1.5 + 2.0 + 2.0 + 1.0

        assertEquals(expected, sandwich.price)
    }
}
