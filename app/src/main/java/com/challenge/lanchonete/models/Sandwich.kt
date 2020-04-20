package com.challenge.lanchonete.models

data class Sandwich(
    val id: Int,
    val name: String,
    var ingredients: MutableList<Ingredient> = mutableListOf(),
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

        ingredients.forEach {
            when (it.name) {
                "Lettuce" -> hasLettuce = true
                "Bacon" -> hasBacon = true
                "Meat Hamburger" -> {
                    countOfBurgers++
                    valueOfBurger = it.value
                }
                "Cheese" -> {
                    countOfCheese++
                    valueOfCheese = it.value
                }
            }

            price += it.value
        }

        var biggestPromotion = 0.0

        if (hasLettuce && !hasBacon) {
            val lighPromotion = price * 0.1
            if (biggestPromotion < lighPromotion) biggestPromotion = lighPromotion
        }
        val quantityOfMeatPromos: Int = countOfBurgers / 3
        val meatPromotion = quantityOfMeatPromos * valueOfBurger
        if (biggestPromotion < meatPromotion) biggestPromotion = meatPromotion

        val quantityOfCheesePromos: Int = countOfCheese / 3
        val cheesePromotion = quantityOfCheesePromos * valueOfCheese
        if (biggestPromotion < cheesePromotion) biggestPromotion = cheesePromotion

        price -= biggestPromotion
    }
}
