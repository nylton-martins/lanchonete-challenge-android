package com.challenge.lanchonete.models

data class Ingredient(
    val id: Int,
    val name: String = "",
    val value: Double = 0.0,
    var quantity: Int = 0
)
