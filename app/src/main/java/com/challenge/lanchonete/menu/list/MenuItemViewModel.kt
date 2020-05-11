package com.challenge.lanchonete.menu.list

import com.challenge.lanchonete.models.Sandwich

data class MenuItemViewModel(
    private val sandwich: Sandwich
) {
    val name = sandwich.name
    val ingredientsString = sandwich.ingredients.values.joinToString(transform = { it.name })
    val price = sandwich.price
}
