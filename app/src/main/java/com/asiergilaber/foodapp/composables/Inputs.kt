package com.asiergilaber.foodapp.composables


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.asiergilaber.foodapp.ui.theme.YellowLight
import com.asiergilaber.foodapp.ui.theme.YellowMain


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextBasic(
    value: String,
    label: String,
    onTextChanged: (String) -> Unit,
    placeholder: String,
    keyboardType: KeyboardType
){
    OutlinedTextField(
        value = value,
        onValueChange = onTextChanged,
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = label) },
        placeholder = { Text(text = placeholder) },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = YellowLight,
            textColor = Color.Black,
            unfocusedBorderColor = YellowMain,
        )

    )
}