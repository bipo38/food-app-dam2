package com.asiergilaber.foodapp.restaurant.data.network

import com.google.gson.annotations.SerializedName

data class RelationDishRestaurant (
    @SerializedName("id_restaurant")
    val idRestaurant: Int,

    @SerializedName("id_food")
    val idFood: Int,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("update_at")
    val updateAt: String
)