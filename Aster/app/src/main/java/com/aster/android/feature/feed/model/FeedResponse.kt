package com.aster.android.feature.feed.model

import java.time.LocalDateTime

data class FeedResponse(
    val id: Long,
    val content: String,
    val feedImgUrl: String,
    val createdAt: LocalDateTime,
    val likeCount: Int,
    val isLiked: Boolean,
)
