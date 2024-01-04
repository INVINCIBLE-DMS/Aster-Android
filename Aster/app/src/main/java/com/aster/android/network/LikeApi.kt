package com.aster.android.network

import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Path

interface LikeApi {

    @POST("/aster/like/{feedId}")
    suspend fun postLike(
        @Path("feedId") feedId: Long,
    ): Response<Void>
}