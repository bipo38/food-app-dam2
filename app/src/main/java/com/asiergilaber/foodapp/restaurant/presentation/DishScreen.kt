package com.asiergilaber.foodapp.restaurant.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun DishScreen(dishViewModel: DishViewModel , modifier: Modifier = Modifier) {

    val dish = dishViewModel.dish.collectAsState().value ?: return
    
    Box(){
        Text(text = dish.name)
    }

}