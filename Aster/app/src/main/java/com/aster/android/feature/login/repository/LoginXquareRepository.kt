package com.aster.android.feature.login.repository

import com.aster.android.feature.login.model.LoginXquareRequest
import com.aster.android.feature.login.model.LoginXquareResponse
import com.aster.android.network.usersApi
import retrofit2.Response

class LoginXquareRepository {

    fun loginXquare(
        loginXquareRequest: LoginXquareRequest,
    ): Response<LoginXquareResponse> = usersApi.login_xquare(loginXquareRequest)
}