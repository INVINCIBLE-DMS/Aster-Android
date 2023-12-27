package com.aster.android.network

import com.aster.android.feature.login.model.LoginXquareRequest
import com.aster.android.feature.login.model.LoginXquareResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignupApi {
    @POST("users/login") //스퀘어 로그인
    suspend fun login_xquare(
        @Body loginXquareRequest: LoginXquareRequest,
    ): Response<LoginXquareResponse>
}