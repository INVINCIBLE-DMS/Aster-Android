package com.aster.android.feature.login.activity

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.aster.android.R
import com.aster.android.base.BaseActivity
import com.aster.android.databinding.ActivityLoginBinding
import com.aster.android.feature.login.model.LoginRequest
import com.aster.android.feature.login.repository.LoginRepository
import com.aster.android.feature.login.viewmodel.LoginViewModel
import com.aster.android.feature.login.viewmodel.factory.LoginViewModelFactory
import com.aster.android.feature.main.activity.MainActivity
import com.aster.android.util.ACCESS_TOKEN
import com.aster.android.util.OK

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    private val loginRepository:LoginRepository by lazy {
        LoginRepository()
    }

    private val loginViewModelFactory : LoginViewModelFactory by lazy {
        LoginViewModelFactory(loginRepository,editor)
    }

    private val loginViewModel : LoginViewModel by lazy {
        ViewModelProvider(this,loginViewModelFactory)[LoginViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.loginActivity = this
        initLoginBtn()
        observeLogin()
    }

    private fun initLoginBtn() {
        binding.btnLogin.setOnClickListener {
            loginViewModel.login(LoginRequest(
                studentId = binding.etLogin.text.toString()
            ))
        }
    }

    private fun observeLogin() {
        loginViewModel.loginResponse.observe(this) {
            when(it.code()) {
                OK-> {
                    ACCESS_TOKEN = it.body()!!.accessToken
                    val intent = Intent(baseContext,MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}