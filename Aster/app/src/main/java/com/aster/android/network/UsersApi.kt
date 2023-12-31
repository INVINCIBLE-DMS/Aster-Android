package com.aster.android.network

import com.aster.android.feature.signup.model.AccountXquareResponse
import com.aster.android.feature.signup.model.LoginXquareRequest
import com.aster.android.feature.signup.model.LoginXquareResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface UsersApi {
    @POST("/users/login") //스퀘어 로그인
    suspend fun login_xquare(
        @Body loginXquareRequest: LoginXquareRequest,
    ): Response<LoginXquareResponse>

    @GET("/users/account-id/{accountId}") //스퀘어 유저 조회
    suspend fun searchUser_xquare(
        @Header("Authorization") accessToken: String,
        @Path("accountId") accountId: String,
    ): Response<AccountXquareResponse>
}