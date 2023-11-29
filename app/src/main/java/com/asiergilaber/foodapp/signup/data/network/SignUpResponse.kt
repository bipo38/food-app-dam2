package com.asiergilaber.foodapp.signup.data.network

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)