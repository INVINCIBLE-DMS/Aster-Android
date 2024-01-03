package com.aster.android.feature.survey.repository

import com.aster.android.feature.survey.model.SurveyAnswerRequest
import com.aster.android.feature.survey.model.SurveyShowResponse
import com.aster.android.network.surveyStorageApi
import retrofit2.Response

class SurveyRepository {

    suspend fun surveyAnswer(
        surveyAnswerRequest: SurveyAnswerRequest,
    ): Response<Void> = surveyStorageApi.surveyAnswer(surveyAnswerRequest)

    suspend fun surveyShow(
    ): Response<List<SurveyShowResponse>> = surveyStorageApi.surveyShow()
}