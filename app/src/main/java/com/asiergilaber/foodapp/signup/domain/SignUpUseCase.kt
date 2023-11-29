package com.asiergilaber.foodapp.signup.domain

import com.asiergilaber.foodapp.signup.data.SignUpRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val netoworkRepository: SignUpRepository
) {
    suspend operator fun invoke(user: String,password: String):Boolean =
        netoworkRepository.doSignUp(user,password)
}