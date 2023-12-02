package com.asiergilaber.foodapp.restaurant.data.network

import com.google.gson.annotations.SerializedName

data class RestaurantResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("address")
    val address: String,

    @SerializedName("cover_url")
    val coverUrl: String,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("update_at")
    val updateAt: String,

    var dishes: List<DishResponse>
)