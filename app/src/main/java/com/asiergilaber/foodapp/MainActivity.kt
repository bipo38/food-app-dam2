package com.asiergilaber.foodapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.asiergilaber.foodapp.core.naviagtion.Navigator
import com.asiergilaber.foodapp.restaurant.presentation.RestaurantViewModel
import com.asiergilaber.foodapp.restaurant.presentation.RestaurantsScreen
import com.asiergilaber.foodapp.signin.presentation.SignInScreen
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
    private val restaurant : RestaurantViewModel by viewModels()

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    NavigationComposable(signInViewModel,signupViewModel,restaurant,navigator)
                }
            }
        }
    }
}

@Composable
fun NavigationComposable(
    signInViewModel: SignInViewModel,
    signUpViewModel: SignUpViewModel,
    restaurantViewModel: RestaurantViewModel,
    navigate: Navigator,
    modifier: Modifier = Modifier,
    startDestination:String = "signIn"
){
    val navController = rememberNavController()
    navigate.navController = navController

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ){
        composable("signIn") {
            SignInScreen(signInViewModel )
        }

        composable("signUp"){
            SignUpScreen(signUpViewModel)
        }

        composable("restaurants"){
            RestaurantsScreen(restaurantViewModel)
        }
    }
}


