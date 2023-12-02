package com.asiergilaber.foodapp.signin.data

import com.asiergilaber.foodapp.signin.data.network.SignInResponse
import com.asiergilaber.foodapp.signin.data.network.SignInService
import retrofit2.Response
import javax.inject.Inject

class SignInRepository @Inject constructor(private val api: SignInService) {

    suspend fun doSignIn(user: String, password: String): Response<SignInResponse> =  api.doSignIn(user, password)

}