package com.asiergilaber.foodapp.signin.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.asiergilaber.foodapp.composables.InputTextBasic
import androidx.compose.runtime.collectAsState
import com.asiergilaber.foodapp.composables.PrimaryBtn




@Composable
fun Body(signInViewModel: SignInViewModel) {

    val email: String by signInViewModel.email.collectAsState()
    val password: String by signInViewModel.password.collectAsState()

    Column {
        InputTextBasic(
            value = email,
            label = "Email",
            onTextChanged = {signInViewModel.onEmailOrPasswordChanged(it, password)},
            placeholder = "Email",
            keyboardType = KeyboardType.Email
        )
        Spacer(modifier = Modifier.size(16.dp))
        InputTextBasic(
            value = password,
            label = "Password",
            onTextChanged = {signInViewModel.onEmailOrPasswordChanged(email, it)},
            placeholder = "Password",
            keyboardType = KeyboardType.Password
        )
        Spacer(modifier = Modifier.size(16.dp))

        Button(onClick = { signInViewModel.onSignInButtonCLicked() }) {
            
        }
    }
}

