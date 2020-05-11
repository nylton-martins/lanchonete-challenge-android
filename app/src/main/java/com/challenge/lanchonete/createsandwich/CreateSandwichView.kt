package com.challenge.lanchonete.createsandwich

import com.challenge.lanchonete.models.Ingredient

interface CreateSandwichView {
    fun showIngredients(ingredients: List<Ingredient>)
    fun showLoading()
    fun hideLoading()
    fun showUnknownError()
    fun showNoIngredientsError()
    fun hideErrors()
    fun hideIngredients()
    fun showPrice(price: Double)
    fun hidePrice()
}
