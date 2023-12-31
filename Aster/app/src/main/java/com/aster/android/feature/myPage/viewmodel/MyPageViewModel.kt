package com.aster.android.feature.myPage.viewmodel

import android.content.SharedPreferences.Editor
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aster.android.feature.myPage.model.MyPageResponse
import com.aster.android.feature.myPage.repository.MyPageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MyPageViewModel(
    private val myPageRepository: MyPageRepository,
    private val editor: Editor,
) :ViewModel(){
    private val _myPageResponse: MutableLiveData<Response<MyPageResponse>> = MutableLiveData()
    val myPageResponse : LiveData<Response<MyPageResponse>> = _myPageResponse

    fun getMyInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            _myPageResponse.postValue(myPageRepository.getMyInfo())
        }
    }
}