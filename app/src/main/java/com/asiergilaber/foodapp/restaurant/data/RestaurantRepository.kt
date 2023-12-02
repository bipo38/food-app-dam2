package com.asiergilaber.foodapp.restaurant.data

import com.asiergilaber.foodapp.restaurant.data.network.RestaurantResponse
import com.asiergilaber.foodapp.restaurant.data.network.RestaurantService
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val api: RestaurantService
) {
    suspend fun getCompleteRestaurant(id: Int) : RestaurantResponse = api.getRestaurantSingle(id)
}