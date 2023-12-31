package com.aster.android.feature.detail.model

data class CommentListResponse(
    val feedResponse: FeedResponse,
    val commentResponse: List<CommentResponse>

)
data class FeedResponse(
    val id: Long,
    val title: String,
    val content: String,
    val feedImgUrl: String,
    val createdAt: String,
    val likeCount: Int,
    val username: String,
    val profileImgUrl: String,
    val commentCount: Int,
    val liked: Boolean
)

data class CommentResponse(
    val id: Long,
    val commentContent: String,
    val commentLikeCount: Int,
    val commentIsUpdated: Boolean,
    val commentWriter: String,
    val commentWriterProfile: String,
    val liked: Boolean
)