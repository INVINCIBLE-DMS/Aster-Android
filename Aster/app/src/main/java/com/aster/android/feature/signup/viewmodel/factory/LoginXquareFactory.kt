package com.aster.android.feature.signup.viewmodel.factory

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aster.android.feature.signup.repository.SignupRepository
import com.aster.android.feature.signup.viewmodel.SignupViewModel

@Suppress("UNCHECKED_CAST")
class LoginXquareFactory(
    private val signupRepository: SignupRepository,
    private val sharedPreferences: SharedPreferences,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        SignupViewModel(signupRepository, sharedPreferences) as T
}