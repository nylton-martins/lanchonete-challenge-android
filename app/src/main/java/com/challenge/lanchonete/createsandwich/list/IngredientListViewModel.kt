package com.challenge.lanchonete.createsandwich.list

import com.challenge.lanchonete.models.Ingredient

data class IngredientListViewModel(
    val ingredients: List<Ingredient>
) {
    val list: List<IngredientItemViewModel> = ingredients.map { ingredient ->
        IngredientItemViewModel(
            ingredient
        )
    }
}
