package com.asiergilaber.foodapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.asiergilaber.foodapp.signin.presentation.Body
import com.asiergilaber.foodapp.signin.presentation.SignInViewModel
import com.asiergilaber.foodapp.signup.presentation.SignUpScreen
import com.asiergilaber.foodapp.signup.presentation.SignUpViewModel
import com.asiergilaber.foodapp.ui.theme.FoodAppTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class FoodApp: Application() {
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val signInViewModel: SignInViewModel by viewModels()
    private val signupViewModel : SignUpViewModel  by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   // Body(signInViewModel)
                    SignUpScreen(signUpViewModel = signupViewModel)
                }
            }
        }
    }
}



