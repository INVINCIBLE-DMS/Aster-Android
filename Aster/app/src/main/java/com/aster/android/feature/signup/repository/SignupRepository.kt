package com.aster.android.feature.signup.repository

import com.aster.android.feature.signup.model.AccountXquareResponse
import com.aster.android.feature.signup.model.LoginXquareRequest
import com.aster.android.feature.signup.model.LoginXquareResponse
import com.aster.android.feature.signup.model.SignupRequest
import com.aster.android.feature.signup.model.SignupResponse
import com.aster.android.network.authApi
import com.aster.android.network.usersApi
import com.aster.android.util.ACCESS_TOKEN
import retrofit2.Response

class SignupRepository {

    suspend fun loginXquare(
        loginXquareRequest: LoginXquareRequest,
    ): Response<LoginXquareResponse> = usersApi.login_xquare(loginXquareRequest)

    suspend fun accountXquare(
        accountId: String,
    ): Response<AccountXquareResponse> = usersApi.searchUser_xquare(
        ACCESS_TOKEN, accountId
    )

    suspend fun postSignup(
        username: String,
        studentId: String,
        profileImgUrl: String,
    ): Response<SignupResponse> = authApi.postSignup(
        SignupRequest(
            username = username,
            studentId = studentId,
            profileImgUrl = profileImgUrl,
        )
    )
}