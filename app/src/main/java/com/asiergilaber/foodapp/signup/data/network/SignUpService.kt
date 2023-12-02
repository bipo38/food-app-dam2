package com.asiergilaber.foodapp.signup.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignUpService @Inject constructor(
    private val client: SignUpClient
) {
    suspend fun doSignUp(user: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = client.doSignUp(SignUpRequest(user,password))

            !response.body()?.email.isNullOrEmpty()
        }
    }
}