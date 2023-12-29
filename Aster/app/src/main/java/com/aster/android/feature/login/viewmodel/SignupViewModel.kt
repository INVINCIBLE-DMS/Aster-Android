package com.aster.android.feature.login.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aster.android.feature.login.model.AccountXquareResponse
import com.aster.android.feature.login.model.LoginXquareRequest
import com.aster.android.feature.login.model.LoginXquareResponse
import com.aster.android.feature.login.repository.SignupRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginXquareViewModel(
    private val signupRepository: SignupRepository,
    private val pref: SharedPreferences,
) : ViewModel() {

    private val _loginXquareResponse = MutableLiveData<Response<LoginXquareResponse>>()
    val loginXquareResponse: LiveData<Response<LoginXquareResponse>> = _loginXquareResponse

    private val _accountXquareResponse = MutableLiveData<Response<AccountXquareResponse>>()
    val accountXquareResponse: LiveData<Response<AccountXquareResponse>> = _accountXquareResponse

    fun loginXquare(
        id: String,
        pw: String,
    ) {
        val loginXquareRequest = LoginXquareRequest(
            account_id = id,
            password = pw,
            device_token = "",
        )

        viewModelScope.launch(Dispatchers.IO) {
            _loginXquareResponse.postValue(signupRepository.loginXquare(loginXquareRequest))
        }
    }

    fun accountXquare(
        account_id: String,
    ) {

        viewModelScope.launch(Dispatchers.IO) {
            _loginXquareResponse.postValue()
        }
    }

}