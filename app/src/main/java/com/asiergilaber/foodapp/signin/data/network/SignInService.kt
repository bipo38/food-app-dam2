package com.asiergilaber.foodapp.signin.data.network

import android.util.Log
import com.asiergilaber.foodapp.core.security.PasswordHash
import com.asiergilaber.foodapp.signin.data.network.response.SignInResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignInService @Inject constructor(
    private val client: SignInClient,

){
    suspend fun doSignIn(user: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = client.doSignIn(SignInResponse(user, password))

            !response.body()?.email.isNullOrEmpty()
        }
    }
}