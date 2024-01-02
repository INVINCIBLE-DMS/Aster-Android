package com.aster.android.feature.login.repository

import com.aster.android.feature.login.model.LoginRequest
import com.aster.android.feature.login.model.LoginResponse
import com.aster.android.network.authApi
import retrofit2.Response

class LoginRepository {

    suspend fun login(
        loginRequest: LoginRequest,
    ): Response<LoginResponse> = authApi.postLogin(loginRequest)
}