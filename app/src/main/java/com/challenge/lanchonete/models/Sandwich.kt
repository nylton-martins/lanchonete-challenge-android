package com.challenge.lanchonete.models

data class Sandwich(
    val id: Int,
    val ingredients: List<Ingredient> = emptyList(),
    val price: Double = 0.0
)
