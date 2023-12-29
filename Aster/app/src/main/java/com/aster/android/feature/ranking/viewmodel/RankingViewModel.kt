package com.aster.android.feature.ranking.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aster.android.feature.ranking.model.RankingResponse
import com.aster.android.feature.ranking.repository.RankingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class RankingViewModel(
    private val rankingRepository: RankingRepository,
    private val editor: SharedPreferences.Editor,
) : ViewModel(){
    private val _rankingResponse : MutableLiveData<Response<List<RankingResponse>>> = MutableLiveData()
    val rankingResponse : LiveData<Response<List<RankingResponse>>> = _rankingResponse

    fun getRanking() {
        viewModelScope.launch(Dispatchers.IO) {
            _rankingResponse.postValue(rankingRepository.getRanking())
        }
    }
}