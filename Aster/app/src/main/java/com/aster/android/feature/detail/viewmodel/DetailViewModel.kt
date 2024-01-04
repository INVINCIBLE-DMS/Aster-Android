package com.aster.android.feature.detail.viewmodel

import android.content.SharedPreferences.Editor
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aster.android.feature.detail.model.CommentListResponse
import com.aster.android.feature.detail.repository.DetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailViewModel(
    private val detailRepository: DetailRepository,
    private val editor: Editor,
) : ViewModel(){
    private val _commentListResponse: MutableLiveData<Response<CommentListResponse>> = MutableLiveData()
    val commentListResponse: LiveData<Response<CommentListResponse>> = _commentListResponse

    fun getCommentList(feedId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _commentListResponse.postValue(detailRepository.getDetail(feedId))
        }
    }

    fun postLike(feedId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            detailRepository.postLike(feedId)
        }
    }
}