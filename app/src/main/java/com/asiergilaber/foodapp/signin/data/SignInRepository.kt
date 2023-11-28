package com.asiergilaber.foodapp.signin.data

import com.asiergilaber.foodapp.signin.data.network.SignInService
import javax.inject.Inject

class SignInRepository @Inject constructor(private val api: SignInService) {

    suspend fun doSignIn(user: String, password: String): Boolean {
        return api.doSignIn(user, password)
    }

}