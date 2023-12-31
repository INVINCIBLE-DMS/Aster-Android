package com.aster.android.feature.signup.activity

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.aster.android.R
import com.aster.android.base.BaseActivity
import com.aster.android.databinding.ActivitySignupBinding
import com.aster.android.feature.signup.repository.SignupRepository
import com.aster.android.feature.signup.viewmodel.SignupViewModel
import com.aster.android.feature.signup.viewmodel.factory.LoginXquareFactory
import com.aster.android.util.ACCESS_TOKEN
import com.aster.android.util.NICKNAME_EXISTS
import com.aster.android.util.NOT_FOUND
import com.aster.android.util.OK

class SignupActivity : BaseActivity<ActivitySignupBinding>(R.layout.activity_signup) {

    private val signupRepository: SignupRepository by lazy {
        SignupRepository()
    }

    private val loginXquareFactory: LoginXquareFactory by lazy {
        LoginXquareFactory(signupRepository, pref)
    }

    private val signupViewModel: SignupViewModel by lazy {
        ViewModelProvider(this, loginXquareFactory)[SignupViewModel::class.java]
    }

    private var id: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.signupActivity = this

        observeLoginXquare()
        observeAccountXquare()
        observeSignup()
    }

    fun loginXquare() {
        id = binding.etSignupId.text.toString()
        val pw = binding.etSignupPw.text.toString()
        if (id.isNotEmpty() && pw.isNotEmpty()) {
            signupViewModel.loginXquare(id, pw)
        }
    }

    private fun observeLoginXquare() {
        signupViewModel.loginXquareResponse.observe(this) {
            when (it.code()) {
                OK -> {
                    ACCESS_TOKEN = it.body()!!.access_token
                    signupViewModel.accountXquare(id)
                }
            }
        }
    }

    private fun observeAccountXquare() {
        signupViewModel.accountXquareResponse.observe(this) {
            when (it.code()) {
                OK -> {
                    it.body()?.apply {
                        signupViewModel.postSignup(
                            name,
                            "$grade$class_num${String.format("%02d", num)}",
                            profile_file_name
                        )
                    }
                }
            }
        }
    }

    private fun observeSignup() {
        signupViewModel.signupResponse.observe(this) {
            when (it.code()) {
                OK -> {
                    ACCESS_TOKEN = "Bearer ${it.body()!!.accessToken}"
                    Toast.makeText(this@SignupActivity, "회원가입에 성공했습니다", Toast.LENGTH_SHORT).show()
                }

                NICKNAME_EXISTS -> {
                    Toast.makeText(this@SignupActivity, "존재하는 사용자입니다", Toast.LENGTH_SHORT).show()
                }

                NOT_FOUND -> {
                    Toast.makeText(this@SignupActivity, "해당 사용자를 찾을 수 없습니다", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}