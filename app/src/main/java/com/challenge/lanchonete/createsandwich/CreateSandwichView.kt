package com.challenge.lanchonete.createsandwich

import com.challenge.lanchonete.createsandwich.list.IngredientListViewModel

interface CreateSandwichView {
    fun showIngredients(ingredientListViewModel: IngredientListViewModel)
    fun showLoading()
    fun hideLoading()
    fun showUnknownError()
    fun showNoIngredientsError()
    fun hideErrors()
    fun hideIngredients()
}
