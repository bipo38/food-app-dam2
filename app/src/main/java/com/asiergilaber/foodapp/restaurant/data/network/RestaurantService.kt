package com.asiergilaber.foodapp.restaurant.data.network

import java.lang.Exception
import javax.inject.Inject

class RestaurantService @Inject constructor(
    private val clientRestaurant : RestaurantClient
) {
     suspend fun getFullRestaurants(id: Int): List<RestaurantResponse> {
        val resRelation = clientRestaurant.relationDishRestaurant()
        val resDishes = clientRestaurant.dishes()
        val resRestaurants = clientRestaurant.restaurants()

        if(  !resRelation.isSuccessful|| !resRestaurants.isSuccessful || !resDishes.isSuccessful ) {
            throw Exception("Failed to retrieve data")
        }

        val relation = resRelation.body()!!
        val dishes = resDishes.body()!!
        val restaurants = resRestaurants.body()!!

        val idRelation = relation.groupBy { it.idRestaurant }

        return restaurants.map { re ->
            re.dishes = idRelation[re.id]!!
                .map { restaurantDishRelation ->
                    dishes.find { it.id == restaurantDishRelation.idFood }!!
                }

            re
        }
    }

    suspend fun getSingleDish(id: Int): DishResponse{
        var dishes = clientRestaurant.dishes()

        if(dishes.isSuccessful){
            return dishes.body()!!.find { it.id == id }!!
        }

        throw Exception("Failed to retrieve dish")
    }

    suspend fun getRestaurantSingle(id: Int): RestaurantResponse{
       return getFullRestaurants(id).find { it.id == id }!!
    }
}