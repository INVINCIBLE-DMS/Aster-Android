package com.aster.android.feature.signup.model

data class LoginXquareRequest (
    val account_id : String,
    val password : String,
    val device_token : String,
)