package com.asiergilaber.foodapp.signup.data.network


import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface SignUpClient {
    //@Headers("Content-Type: application/json" , "apikey: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNsdXRydHFjZWVyZ2FmZHRxamViIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDAwNTI2MDksImV4cCI6MjAxNTYyODYwOX0.M0LOr8aHu4GA8TE9B-7skWZl348m2YF1ACUX_CZQcBw")
    @POST("auth/v1/signup")
    suspend fun doSignUp(@Body req: SignUpRequest): Response<SignUpResponse>
}