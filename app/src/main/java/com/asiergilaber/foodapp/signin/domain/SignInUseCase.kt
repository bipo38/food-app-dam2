package com.asiergilaber.foodapp.signin.domain

import android.annotation.SuppressLint
import com.asiergilaber.foodapp.core.dependencyinjection.ClientNet
import com.asiergilaber.foodapp.signin.data.SignInRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val networkRepository: SignInRepository,
    private val networkUser : ClientNet
) {
    @SuppressLint("SuspiciousIndentation")
    suspend operator fun invoke(user: String, password: String) : Boolean {
      val response = networkRepository.doSignIn(user, password)

        if(response.isSuccessful){
            val token = response.body()?.accessToken

            if(!token.isNullOrEmpty()){
                networkUser.setToken(token)
                return true
            }
        }
        return false
    }

}