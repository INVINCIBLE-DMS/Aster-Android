package com.aster.android.feature.survey.repository

import com.aster.android.feature.survey.model.SurveyAnswerRequest
import com.aster.android.feature.survey.model.SurveyShowResponse
import com.aster.android.network.surveyStorageApi
import com.aster.android.util.ACCESS_TOKEN
import retrofit2.Response

class SurveyRepository {

    suspend fun surveyAnswer(
        surveyAnswerRequest: SurveyAnswerRequest,
    ): Response<Void> = surveyStorageApi.surveyAnswer(ACCESS_TOKEN, surveyAnswerRequest)

    suspend fun surveyShow(
    ): Response<List<SurveyShowResponse>> = surveyStorageApi.surveyShow(ACCESS_TOKEN)
}