package com.aster.android.feature.login.model

data class LoginXquareRequest (
    val account_id : String,
    val password : String,
    val device_token : String,
)