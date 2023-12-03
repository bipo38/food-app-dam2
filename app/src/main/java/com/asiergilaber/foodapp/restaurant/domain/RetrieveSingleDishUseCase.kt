package com.asiergilaber.foodapp.restaurant.domain

import com.asiergilaber.foodapp.restaurant.data.RestaurantRepository
import javax.inject.Inject

class RetrieveSingleDishUseCase @Inject constructor(
    private val restaurantRepository: RestaurantRepository
) {
    suspend operator fun invoke(id: Int) : Dish {
        val singleDish = restaurantRepository.getSingleDish(id)

        return Dish(
            id = singleDish.id,
            name = singleDish.name,
            description = singleDish.description,
            ingredients = singleDish.ingredients,
            allergens = singleDish.allergens,
            coverUrl = singleDish.coverUrl,
            createdAt = singleDish.createdAt,
            updateAt = singleDish.updateAt
        )
    }
}