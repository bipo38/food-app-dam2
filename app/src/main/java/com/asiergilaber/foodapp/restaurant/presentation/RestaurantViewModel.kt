package com.asiergilaber.foodapp.restaurant.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.asiergilaber.foodapp.core.naviagtion.Navigator
import com.asiergilaber.foodapp.restaurant.domain.Restaurant
import com.asiergilaber.foodapp.restaurant.domain.RetrieveCompleteRestaurantsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    private val navigator: Navigator,
    private val restaurantUseCase: RetrieveCompleteRestaurantsUseCase,
): ViewModel() {
    private val _restaurant: MutableStateFlow<Restaurant?> = MutableStateFlow(null)
    val restaurant = _restaurant


    fun logout(){
        navigator.navigate("signIn")
    }

    fun getRestaurant(id: Int) {
        viewModelScope.launch {
            _restaurant.value = restaurantUseCase(id)

        }
    }

}