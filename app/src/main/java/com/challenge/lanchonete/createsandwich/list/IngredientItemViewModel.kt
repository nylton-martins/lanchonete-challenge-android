package com.challenge.lanchonete.createsandwich.list

import com.challenge.lanchonete.models.Ingredient

data class IngredientItemViewModel(
    private val ingredient: Ingredient
) {
    val name = ingredient.name
    val value = ingredient.value
}
