package com.aster.android.feature.detail.repository

import com.aster.android.feature.detail.model.CommentListResponse
import com.aster.android.network.commentApi
import retrofit2.Response

class DetailRepository {
    suspend fun getDetail(
        feedId:Long,
    ): Response<CommentListResponse> = commentApi
}