package com.asiergilaber.foodapp.signin.data.network

import com.google.gson.annotations.SerializedName

data class SignInRequest (
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)