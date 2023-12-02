package com.asiergilaber.foodapp.core.dependencyinjection

import com.asiergilaber.foodapp.signin.data.network.SignInClient
import com.asiergilaber.foodapp.signup.data.network.SignUpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.Retrofit.*
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): ClientNet = ClientNet()

    @Singleton
    @Provides
    fun provideSignInClient(networkUser: ClientNet): SignInClient = networkUser.retrofit.create(SignInClient::class.java)

    @Singleton
    @Provides
    fun provideSignupClient(networkUser: ClientNet): SignUpClient =  networkUser.retrofit.create(SignUpClient::class.java)
}

class ClientNet {
    private val apiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNsdXRydHFjZWVyZ2FmZHRxamViIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDAwNTI2MDksImV4cCI6MjAxNTYyODYwOX0.M0LOr8aHu4GA8TE9B-7skWZl348m2YF1ACUX_CZQcBw"

    lateinit var retrofit: Retrofit

    init {
        retrofitMake(null)
    }

    fun setToken(token: String){
        retrofitMake(token)
    }
    private fun retrofitMake(token: String?){
        val build = okhttp3.OkHttpClient.Builder()
            .addInterceptor() {
                chain ->
                val makeReq = chain.request().newBuilder()
                makeReq.addHeader("apikey", apiKey)

                if (!token.isNullOrEmpty()) {
                    makeReq.addHeader("Authorization", "Bearer $token")
                }

                chain.proceed(makeReq.build())
            }.build()

        retrofit = Retrofit.Builder().client(build)
            .baseUrl("https://clutrtqceergafdtqjeb.supabase.co/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}




















