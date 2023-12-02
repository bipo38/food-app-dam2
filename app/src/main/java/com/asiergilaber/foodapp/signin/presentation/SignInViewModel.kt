package com.asiergilaber.foodapp.signin.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asiergilaber.foodapp.core.naviagtion.Navigator
import com.asiergilaber.foodapp.signin.domain.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val navigator: Navigator,
    private val signInUseCase: SignInUseCase
) : ViewModel()  {

    private val _email = MutableStateFlow("asiergg60@gmail.com")
    val email = _email

    private val _password = MutableStateFlow("123456")
    val password = _password


    fun onEmailOrPasswordChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
    }

    fun navigateSignUp(){
        navigator.navigate("signUp")
    }

    fun onSignInButtonClicked() {
        viewModelScope.launch {
            val result = signInUseCase(email.value ,password.value)

            if(result){
                navigator.navigate("restaurants")
            }else {
                Log.i("Login" , "Login bad")
            }

        }
    }
}