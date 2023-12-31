package com.aster.android.network

import com.aster.android.feature.detail.model.CommentListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface CommentApi {

    @GET("/aster/comment/{feedId}")
    suspend fun getCommentList(
        @Header("Authorization") accessToken: String,
        @Path("feedId") feedId: Long,
    ): Response<CommentListResponse>
}