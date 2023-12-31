package com.aster.android.network

import com.aster.android.feature.feed.model.FeedResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface FeedApi {

    @POST("/aster/feed/")
    suspend fun postWriteFeed(
    )
    @GET("/aster/feed/")
    suspend fun getFeedList(
    ): Response<List<FeedResponse>>
}