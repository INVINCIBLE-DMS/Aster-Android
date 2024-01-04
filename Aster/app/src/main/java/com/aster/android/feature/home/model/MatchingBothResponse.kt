package com.aster.android.feature.home.model

data class MatchingBothResponse(
    val matchScore: Int,
    val user1profileImgUrl: String,
    val user1username: String,
    val user2profileImgUrl: String,
    val user2username: String,
)