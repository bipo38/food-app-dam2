package com.asiergilaber.foodapp.restaurant.data.network

import com.google.gson.annotations.SerializedName

data class DishResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("cover_url")
    val coverUrl: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("update_at")
    val updateAt: String,

    @SerializedName("ingredients")
    val ingredients: List<String>,

    @SerializedName("allergens")
    val allergens: List<String>,

)