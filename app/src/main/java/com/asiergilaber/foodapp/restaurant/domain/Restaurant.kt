package com.asiergilaber.foodapp.restaurant.domain

class Restaurant (
    val id: Int,

    val name: String,
    val description: String,
    val address: String,
    val coverUrl: String,
    val dishes: List<Dish>,

    val createdAt: String,
    val updateAt: String
)