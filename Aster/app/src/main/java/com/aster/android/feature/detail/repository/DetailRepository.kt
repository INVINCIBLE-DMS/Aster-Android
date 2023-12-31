package com.aster.android.feature.detail.repository

import com.aster.android.feature.detail.model.CommentListResponse
import com.aster.android.network.commentApi
import com.aster.android.util.ACCESS_TOKEN
import retrofit2.Response

class DetailRepository {
    suspend fun getDetail(
        feedId:Long,
    ): Response<CommentListResponse> = commentApi.getCommentList(ACCESS_TOKEN,feedId)
}