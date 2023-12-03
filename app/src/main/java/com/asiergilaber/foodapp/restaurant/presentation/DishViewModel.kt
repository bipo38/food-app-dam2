package com.asiergilaber.foodapp.restaurant.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asiergilaber.foodapp.core.naviagtion.Navigator
import com.asiergilaber.foodapp.restaurant.domain.Dish
import com.asiergilaber.foodapp.restaurant.domain.RetrieveSingleDishUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DishViewModel @Inject constructor(
    private val dishUserCase: RetrieveSingleDishUseCase,
    private val navigator: Navigator,

): ViewModel() {
    private val _dish = MutableStateFlow<Dish?>(null)
    val dish = _dish

    fun navigateBack() {
        navigator.navigate("restaurants")
    }

    fun retrieveDish(id: Int){
        viewModelScope.launch {
            _dish.value = dishUserCase(id)
        }
    }

}