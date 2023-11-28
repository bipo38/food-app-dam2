package com.asiergilaber.foodapp.signin.data.network.response

import com.google.gson.annotations.SerializedName

data class SignInResponse (
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)