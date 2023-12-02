package com.asiergilaber.foodapp.restaurant.data.network

import retrofit2.Response
import retrofit2.http.GET

interface RestaurantClient {
    @GET("/rest/v1/dish?select=*")
    suspend fun relationDishRestaurant(): Response<List<RelationDishRestaurant>>

    @GET("/rest/v1/food?select=*")
    suspend fun dishes(): Response<List<DishResponse>>

    @GET("/rest/v1/restaurant?select=*")
    suspend fun restaurants(): Response<List<RestaurantResponse>>

}