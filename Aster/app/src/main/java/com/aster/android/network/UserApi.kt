package com.aster.android.network

import com.aster.android.feature.home.model.MatchingBothRequest
import com.aster.android.feature.home.model.MatchingBothResponse
import com.aster.android.feature.home.model.MatchingResponse
import com.aster.android.feature.myPage.model.MyPageResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("/aster/user/my-info")
    suspend fun getMyPage(
    ): Response<MyPageResponse>

    @GET("/aster/user/")
    suspend fun getMatching(
        @Query("username") username: String,
    ): Response<MatchingResponse>

    @GET("aster/user/both")
    suspend fun getMatchBoth(
        @Body matchingBothRequest: MatchingBothRequest,
    ):Response<MatchingBothResponse>
}