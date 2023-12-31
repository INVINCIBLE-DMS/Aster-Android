package com.aster.android.network

import com.aster.android.feature.home.model.MatchingRequest
import com.aster.android.feature.home.model.MatchingResponse
import com.aster.android.feature.myPage.model.MyPageResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header

interface UserApi {
    @GET("/aster/user/my-info")
    suspend fun getMyPage(
        @Header("Authorization") accessToken: String,
    ): Response<MyPageResponse>

    @GET("/aster/user/")
    suspend fun getMatching(
        @Header("Authorization") accessToken: String,
        @Body requset: MatchingRequest,
    ): Response<MatchingResponse>
}