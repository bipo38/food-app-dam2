package com.asiergilaber.foodapp.signin.data.network

import retrofit2.Response
import javax.inject.Inject

class SignInService @Inject constructor(
    private val client: SignInClient,

){
    suspend fun doSignIn(email: String, password: String): Response<SignInResponse> = client.doSignIn(SignInRequest(email, password))
}