package com.challenge.lanchonete.models

data class Lanche(
    val id: Int,
    val ingredients: List<Ingredient> = emptyList(),
    val price: Int = 0
)
