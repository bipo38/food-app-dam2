package com.asiergilaber.foodapp.restaurant.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter

@Composable
fun RestaurantsScreen(restaurantViewModel: RestaurantViewModel , modifier: Modifier = Modifier) {
    val restaurant = restaurantViewModel.restaurant.collectAsState().value

    if (restaurant == null) {
        restaurantViewModel.getRestaurant(1)
    }

    Box(){
        AsyncImage(
            model = restaurant?.coverUrl ?: "",
            contentDescription = "Restaurant image",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .height(250.dp)
                .alpha(0.8f),

            )

        Row(modifier = Modifier.padding(10.dp)) {
                IconButton(modifier = Modifier
                    .background(Color.White)
                    .padding(10.dp)
                    .clip(CircleShape) ,
                    onClick = { restaurantViewModel.logout() }) {
                    Icon(Icons.Outlined.ArrowBack , "Logout")
                }
        }


        

    }


}