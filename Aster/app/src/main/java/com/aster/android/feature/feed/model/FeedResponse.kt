package com.aster.android.feature.feed.model

data class FeedResponse(
    val id: Long,
    val content: String,
    val feedImgUrl: String,
    val createdAt: String,
    val likeCount: Int,
    val isLiked: Boolean,
    val commentCount: Int,
    val profileImgUrl: String,
    val username: String,
)
