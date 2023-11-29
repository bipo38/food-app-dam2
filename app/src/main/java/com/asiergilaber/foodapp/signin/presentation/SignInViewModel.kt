package com.asiergilaber.foodapp.signin.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asiergilaber.foodapp.signin.domain.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
) : ViewModel()  {

    private val _email = MutableStateFlow("")
    val email = _email

    private val _password = MutableStateFlow("")
    val password = _password


    fun onEmailOrPasswordChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
    }

    fun onSignInButtonCLicked() : Unit {
        viewModelScope.launch {
            val result = signInUseCase(_email.value ,_password.value)

            if(result) {
                Log.i("COACH", "Navigate to Home")
            }

        }
    }
}