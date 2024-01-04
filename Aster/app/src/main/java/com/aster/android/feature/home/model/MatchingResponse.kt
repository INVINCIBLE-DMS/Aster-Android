package com.aster.android.feature.home.model

data class MatchingResponse(
    val matchScore: Int,
    val profileImgUrl: String,
    val username: String,
)