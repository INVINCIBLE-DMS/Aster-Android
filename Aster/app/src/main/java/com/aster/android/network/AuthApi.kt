package com.aster.android.network

import com.aster.android.feature.login.model.LoginRequest
import com.aster.android.feature.login.model.LoginResponse
import com.aster.android.feature.signup.model.SignupRequest
import com.aster.android.feature.signup.model.SignupResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("/aster/auth/")
    suspend fun postSignup(
        @Body request: SignupRequest
    ): Response<SignupResponse>

    @POST("/aster/auth/login")
    suspend fun postLogin(
        @Body request:LoginRequest
    ): Response<LoginResponse>
}