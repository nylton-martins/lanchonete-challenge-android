package com.challenge.lanchonete.models

import kotlin.math.round

data class Sandwich(
    val id: Int,
    val name: String,
    var ingredients: LinkedHashMap<Int, Ingredient> = linkedMapOf(),
    var price: Double = 0.0
) {
    fun calculatePrice() {
        var hasLettuce = false
        var hasBacon = false
        var countOfBurgers = 0
        var countOfCheese = 0
        var valueOfBurger = 0.0
        var valueOfCheese = 0.0
        price = 0.0

        ingredients.values.forEach {
            when (it.name) {
                "Lettuce" -> hasLettuce = true
                "Bacon" -> hasBacon = true
                "Meat Hamburger" -> {
                    countOfBurgers = it.quantity
                    valueOfBurger = it.value
                }
                "Cheese" -> {
                    countOfCheese = it.quantity
                    valueOfCheese = it.value
                }
            }

            price += (it.value * it.quantity)
        }

        var biggestPromotion = 0.0

        if (hasLettuce && !hasBacon) {
            val lightPromotion = price * 0.10
            if (biggestPromotion < lightPromotion) biggestPromotion = lightPromotion
        }
        val quantityOfMeatPromos: Int = countOfBurgers / 3
        val meatPromotion = quantityOfMeatPromos * valueOfBurger
        if (biggestPromotion < meatPromotion) biggestPromotion = meatPromotion

        val quantityOfCheesePromos: Int = countOfCheese / 3
        val cheesePromotion = quantityOfCheesePromos * valueOfCheese
        if (biggestPromotion < cheesePromotion) biggestPromotion = cheesePromotion

        price -= biggestPromotion
        price = round(price * 100) / 100
    }
}
