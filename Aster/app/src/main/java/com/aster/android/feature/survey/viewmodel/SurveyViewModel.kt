package com.aster.android.feature.survey.viewmodel

import android.content.SharedPreferences.Editor
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aster.android.feature.survey.model.SurveyAnswerRequest
import com.aster.android.feature.survey.model.SurveyShowResponse
import com.aster.android.feature.survey.repository.SurveyRepository
import com.aster.android.feature.survey.type.AnswerType
import com.aster.android.feature.survey.type.SurveyType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class SurveyViewModel(
    private val surveyRepository: SurveyRepository,
    private val editor: Editor,
) : ViewModel() {
    private val _surveyShowResponse = MutableLiveData<Response<List<SurveyShowResponse>>>()
    val surveyShowResponse: LiveData<Response<List<SurveyShowResponse>>> = _surveyShowResponse

    fun surveyAnswer(
        surveyType: SurveyType,
        answerType: AnswerType,
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            surveyRepository.surveyAnswer(
                SurveyAnswerRequest(
                    surveyType = surveyType,
                    answerType = answerType,
                )
            )
        }
    }

    fun surveyShow() {
        viewModelScope.launch(Dispatchers.IO) {
            _surveyShowResponse.postValue(surveyRepository.surveyShow())
        }
    }

}