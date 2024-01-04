package com.aster.android.feature.detail.repository

import com.aster.android.feature.detail.model.CommentListResponse
import com.aster.android.network.commentApi
import com.aster.android.network.likeApi
import retrofit2.Response

class DetailRepository {
    suspend fun getDetail(
        feedId:Long,
    ): Response<CommentListResponse> = commentApi.getCommentList(feedId)

    suspend fun postLike(
        feedId: Long,
    ):Response<Void> = likeApi.postLike(feedId)
}