package com.asiergilaber.foodapp.signin.domain

import com.asiergilaber.foodapp.core.security.PasswordHash
import com.asiergilaber.foodapp.signin.data.SignInRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val networkRepository: SignInRepository
) {
    suspend operator fun invoke(user: String, password: String):Boolean =
        networkRepository.doSignIn(user, password)
}