package com.aster.android.feature.login.viewmodel

import android.content.SharedPreferences.Editor
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aster.android.feature.login.model.LoginRequest
import com.aster.android.feature.login.model.LoginResponse
import com.aster.android.feature.login.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(
    private val loginRepository: LoginRepository,
    private val editor: Editor,
): ViewModel() {

    private val _loginResponse = MutableLiveData<Response<LoginResponse>>()
    val loginResponse : LiveData<Response<LoginResponse>> = _loginResponse

    fun login(
        loginRequest: LoginRequest
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            _loginResponse.postValue(loginRepository.login(loginRequest))
        }
    }
}