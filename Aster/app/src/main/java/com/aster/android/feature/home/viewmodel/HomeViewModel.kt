package com.aster.android.feature.home.viewmodel

import android.content.SharedPreferences.Editor
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aster.android.feature.home.model.MatchingBothRequest
import com.aster.android.feature.home.model.MatchingBothResponse
import com.aster.android.feature.home.model.MatchingResponse
import com.aster.android.feature.home.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(
    private val homeRepository: HomeRepository,
    private val editor: Editor,
) : ViewModel() {

    private val _matchIngResponse: MutableLiveData<Response<MatchingResponse>> = MutableLiveData()
    val matchingResponse: LiveData<Response<MatchingResponse>> = _matchIngResponse

    private val _matchingBothResponse: MutableLiveData<Response<MatchingBothResponse>> =
        MutableLiveData()
    val matchingBothResponse: LiveData<Response<MatchingBothResponse>> = _matchingBothResponse

    fun getMatching(
        username: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            _matchIngResponse.postValue(homeRepository.getMatch(username))
        }
    }

    fun getMatchingBoth(
        matchingBothRequest: MatchingBothRequest
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            _matchingBothResponse.postValue(homeRepository.getBothMatch(matchingBothRequest))
        }
    }
}