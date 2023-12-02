package com.asiergilaber.foodapp.restaurant.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.asiergilaber.foodapp.ui.theme.YellowMain


@Composable
fun RestaurantsScreen(restaurantViewModel: RestaurantViewModel , modifier: Modifier = Modifier) {
    val restaurant = restaurantViewModel.restaurant.collectAsState().value

    if (restaurant == null) {
        restaurantViewModel.getRestaurant(1)
    }

    Column {
        Box() {
            AsyncImage(
                model = restaurant?.coverUrl ?: "",
                contentDescription = "Restaurant image",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .alpha(0.7f),

                )
            Column {
                Row(modifier = Modifier.padding(10.dp)) {
                    IconButton(modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(2.dp),
                        onClick = { restaurantViewModel.logout() }) {
                        Icon(Icons.Outlined.ExitToApp, "Logout")
                    }

                    IconButton(modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(2.dp),
                        onClick = { }) {
                        Icon(Icons.Outlined.FavoriteBorder, "Logout")
                    }
                    IconButton(modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(2.dp),
                        onClick = {  }) {
                        Icon(Icons.Outlined.LocationOn, "Logout")
                    }


                }
                Text(
                    text = restaurant?.name ?: "",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )

            }
        }

        Box( modifier = modifier
            .padding(8.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())){
            val dishes =
                arrayOf(restaurant?.dishes, restaurant?.dishes).flatMap { it ?: emptyList() }
            

            
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {

                for (dish in dishes) {
                    Row(horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(model = dish.coverUrl,
                            contentDescription = dish.name ?: "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(100.dp, 100.dp)
                                .clip(MaterialTheme.shapes.medium)
                        )
                        Spacer(modifier = Modifier.padding(horizontal = 4.dp))

                        Column(modifier = Modifier.widthIn(0.dp,200.dp)) {
                            Text(text = dish.name,
                                style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            ))
                            Spacer(modifier = Modifier.padding(top = 2.dp))
                            Text(text = dish.description,
                                style = MaterialTheme.typography.bodySmall.copy(
                                fontWeight = FontWeight.Medium,
                                color = Color.Gray
                            ))
                            Spacer(modifier = Modifier.padding(top = 2.dp))
                            Text(text = "12,00€")
                        }

                        IconButton(onClick = { /*TODO*/ } , modifier = Modifier
                            .clip(CircleShape)
                            .background(YellowMain)) {
                            Icon(Icons.Outlined.Add, "Add" , tint = Color.White)
                        }

                    }

                }
            }

        }
    }
}