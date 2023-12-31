package com.aster.android.feature.feed.viewmodel

import android.content.SharedPreferences.Editor
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aster.android.feature.feed.model.FeedResponse
import com.aster.android.feature.feed.repository.FeedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class FeedViewModel(
    private val feedRepository: FeedRepository,
    private val editor: Editor,
) : ViewModel() {
    private val _feedResponse: MutableLiveData<Response<List<FeedResponse>>> = MutableLiveData()
    val feedResponse: LiveData<Response<List<FeedResponse>>> = _feedResponse

    fun getFeedList() {
        viewModelScope.launch(Dispatchers.IO) {
            _feedResponse.postValue(feedRepository.getFeed())
        }
    }
}