package com.aster.android.feature.login.model

data class AccountXquareResponse(
    val name: String,
    val id: String,
    val birth_day: String,
    val grade: Int,
    val class_num: Int,
    val profile_image_url: String,
    val password: String,
    val account_id: String,
    val num: Int,
)
