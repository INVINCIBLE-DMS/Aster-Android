package com.aster.android.network

import com.aster.android.feature.login.model.AccountXquareResponse
import com.aster.android.feature.login.model.LoginXquareRequest
import com.aster.android.feature.login.model.LoginXquareResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface UsersApi {
    @POST("users/login") //스퀘어 로그인
    fun login_xquare(
        @Body loginXquareRequest: LoginXquareRequest,
    ): Response<LoginXquareResponse>

    @GET("users/account-id/{accountId}") //스퀘어 유저 조회
    fun searchUser_xquare(
        @Header("Authorization") accessToken: String,
        @Path("accountId") accountId: String,
    ): Response<AccountXquareResponse>
}