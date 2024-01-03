package com.aster.android.network

import com.aster.android.feature.survey.model.SurveyAnswerRequest
import com.aster.android.feature.survey.model.SurveyShowResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT

interface SurveyStorageApi {

    @GET("/aster/survey-storage")
    suspend fun surveyShow(
    ): Response<List<SurveyShowResponse>>

    @PUT("aster/survey-storage")
    suspend fun surveyAnswer(
        @Body surveyAnswerRequest: SurveyAnswerRequest,
    ): Response<Void>
}