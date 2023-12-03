package com.asiergilaber.foodapp.restaurant.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.asiergilaber.foodapp.composables.PrimaryBtn
import com.asiergilaber.foodapp.ui.theme.YellowLight

@Composable
fun DishScreen(dishViewModel: DishViewModel , modifier: Modifier = Modifier) {

    val dish = dishViewModel.dish.collectAsState().value ?: return
    Column {
        Box( modifier
            .padding(start = 16.dp, top = 16.dp)) {
            IconButton(modifier = Modifier
                .clip(CircleShape)
                .background(YellowLight)
                .padding(2.dp),
                onClick = { dishViewModel.navigateBack()}) {
                Icon(Icons.Outlined.ArrowBack, "Logout")
            }
        }

        Box(
            modifier
                .fillMaxSize()
                .padding(16.dp)){
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                AsyncImage(model = dish.coverUrl, contentDescription = dish.name,
                    modifier = Modifier
                        .size(200.dp, 200.dp)
                        .clip(MaterialTheme.shapes.medium))

                Spacer(modifier = Modifier.padding(bottom = 8.dp))

                Text(text = dish.name, modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp) , style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                ) )

                Text(text = dish.description,
                    modifier = modifier.padding(start = 8.dp),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray
                    ))
                Spacer(modifier = Modifier.padding(bottom = 8.dp))
                Text(text = "12,00€", modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp) , style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                ) )

                Spacer(modifier = Modifier.padding(bottom = 8.dp))
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)) {
                    Text(text = "Allergens: ",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start
                        ))
                    Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                    dish.allergens.forEach{
                            allergen ->
                        Text(text = allergen)
                        Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                    }
                }
                Spacer(modifier = Modifier.padding(bottom = 8.dp))
                PrimaryBtn(text = "Add to Cart", onClick = {})
            }
        }

    }


}