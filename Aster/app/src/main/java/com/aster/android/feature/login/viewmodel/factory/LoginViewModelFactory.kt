package com.aster.android.feature.login.viewmodel.factory

import android.content.SharedPreferences.Editor
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aster.android.feature.login.repository.LoginRepository
import com.aster.android.feature.login.viewmodel.LoginViewModel

@Suppress("UNCHECKED_CAST")
class LoginViewModelFactory(
    private val loginRepository: LoginRepository,
    private val editor: Editor,
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(loginRepository,editor) as T
    }
}