package com.asiergilaber.foodapp.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.asiergilaber.foodapp.ui.theme.YellowMain

@Composable
fun PrimaryBtn(text: String,  onClick: Unit, enabled: Boolean = true ) {
    Button(onClick = { onClick }  , enabled = enabled, colors = ButtonDefaults.buttonColors(
        contentColor = Color.White,
        containerColor = YellowMain
    ),  modifier = Modifier
        .height(62.dp)
        .fillMaxWidth()
    ) {
        Text(text = text)

    }
}


@Composable
fun SecondaryBtn(text: String, enabled: Boolean = true ) {
    OutlinedButton(onClick = {println("Button clicked!")}  , enabled = enabled, colors = ButtonDefaults.buttonColors(
        contentColor = YellowMain
    ),  modifier = Modifier
        .height(62.dp)
        .fillMaxWidth()
    ) {
        Text(text = text)

    }
}