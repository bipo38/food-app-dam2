package com.asiergilaber.foodapp.signup.data

import com.asiergilaber.foodapp.signup.data.network.SignUpService
import javax.inject.Inject

class SignUpRepository @Inject constructor(
    private val api: SignUpService
) {
    suspend fun doSignUp(user: String, password: String) : Boolean {
        return api.doSignUp(user,password)
    }
}