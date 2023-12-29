package com.aster.android.feature.login.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aster.android.feature.login.model.AccountXquareResponse
import com.aster.android.feature.login.model.LoginXquareRequest
import com.aster.android.feature.login.model.LoginXquareResponse
import com.aster.android.feature.login.model.SignupResponse
import com.aster.android.feature.login.repository.SignupRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class SignupViewModel(
    private val signupRepository: SignupRepository,
    private val pref: SharedPreferences,
) : ViewModel() {

    private val _loginXquareResponse = MutableLiveData<Response<LoginXquareResponse>>()
    val loginXquareResponse: LiveData<Response<LoginXquareResponse>> = _loginXquareResponse

    private val _accountXquareResponse = MutableLiveData<Response<AccountXquareResponse>>()
    val accountXquareResponse: LiveData<Response<AccountXquareResponse>> = _accountXquareResponse

    private val _signupResponse = MutableLiveData<Response<SignupResponse>>()
    val signupResponse: LiveData<Response<SignupResponse>> = _signupResponse

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
            _accountXquareResponse.postValue(signupRepository.accountXquare(account_id))
        }
    }

    fun postSignup(
        username: String,
        studentId: String,
        profileImgUrl: String,
    ) {

        viewModelScope.launch(Dispatchers.IO) {
            _signupResponse.postValue(
                signupRepository.postSignup(
                    username,
                    studentId,
                    profileImgUrl
                )
            )
        }
    }
}