package com.aster.android.feature.login.viewmodel.factory

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aster.android.feature.login.repository.SignupRepository
import com.aster.android.feature.login.viewmodel.SignupViewModel

@Suppress("UNCHECKED_CAST")
class LoginXquareFactory(
    private val signupRepository: SignupRepository,
    private val sharedPreferences: SharedPreferences,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        SignupViewModel(signupRepository, sharedPreferences) as T
}