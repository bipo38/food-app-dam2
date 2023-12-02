package com.asiergilaber.foodapp.restaurant.domain

import com.asiergilaber.foodapp.restaurant.data.RestaurantRepository
import javax.inject.Inject

class RetrieveCompleteRestaurantsUseCase @Inject constructor(
    private val restaurantRepository: RestaurantRepository
) {
    suspend operator fun invoke(id: Int): Restaurant {
        val restaurant = restaurantRepository.getCompleteRestaurant(id)

        return Restaurant(
            id = restaurant.id,
            name = restaurant.name,
            description = restaurant.description,
            address = restaurant.address,
            coverUrl = restaurant.coverUrl,
            dishes = restaurant.dishes.map { dish ->
                Dish(
                    id = dish.id,
                    name = dish.name,
                    description = dish.description,
                    ingredients = dish.ingredients,
                    allergens = dish.allergens,
                    coverUrl = dish.coverUrl,
                    createdAt = dish.createdAt,
                    updateAt = dish.updateAt
                )
            },
            createdAt = restaurant.createdAt,
            updateAt = restaurant.updateAt
        )
    }
}