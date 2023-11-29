package com.asiergilaber.foodapp.signup.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asiergilaber.foodapp.signup.domain.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {
    private val _email = MutableStateFlow("")
    val email = _email

    private val _password = MutableStateFlow("")
    val password = _password

    private val _name = MutableStateFlow("")
    val name = _name

    fun onEmailOrPasswordChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
    }

    fun onNameChanged(name: String){
        _name.value = name
    }

    fun onSignUpButtonCLicked() : Unit {
        viewModelScope.launch {
            val result = signUpUseCase(_email.value ,_password.value)

            if(result) {
                Log.i("COACH", "Navigate to Home")
            }

        }
    }
}