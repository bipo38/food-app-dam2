package com.asiergilaber.foodapp.signup.presentation

import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asiergilaber.foodapp.core.naviagtion.Navigator
import com.asiergilaber.foodapp.signup.domain.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
    private val navigator: Navigator,
) : ViewModel() {
    private val _email = MutableStateFlow("")
    val email = _email

    private val _password = MutableStateFlow("")
    val password = _password

    private val _name = MutableStateFlow("")
    val name = _name
    fun onEmailOrPasswordChanged(email: String, password: String , name: String) {
        _email.value = email
        _password.value = password
        _name.value = name
    }

    fun navigateSignIn() {
        navigator.navigate("signIn")
    }

    fun onSignUpButtonClicked() : Unit {
        viewModelScope.launch {
           val result = signUpUseCase(email.value ,password.value)

            if(result) {
                navigator.navigate("signIn")
            }else {
                Log.i("SignUp" , "Wrong Sign up")
            }

        }
    }
}