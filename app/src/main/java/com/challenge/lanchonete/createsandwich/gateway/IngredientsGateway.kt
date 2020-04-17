package com.challenge.lanchonete.createsandwich.gateway

import com.challenge.lanchonete.models.Ingredient

interface IngredientsGateway {

    fun getAllIngredients(): List<Ingredient>
}
