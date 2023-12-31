package com.aster.android.feature.signup.model


data class LoginXquareResponse(
    val access_token: String,
    val access_token_expire_at: String,
    val refresh_token: String,
    val refresh_token_expire_at: String,
    val role: String,
)