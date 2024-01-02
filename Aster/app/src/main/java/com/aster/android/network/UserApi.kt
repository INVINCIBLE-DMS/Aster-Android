package com.aster.android.network

import com.aster.android.feature.home.model.MatchingRequest
import com.aster.android.feature.home.model.MatchingResponse
import com.aster.android.feature.myPage.model.MyPageResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface UserApi {
    @GET("/aster/user/my-info")
    suspend fun getMyPage(
    ): Response<MyPageResponse>

    @GET("/aster/user/")
    suspend fun getMatching(
        @Body matchingRequest: MatchingRequest,
    ): Response<MatchingResponse>
}