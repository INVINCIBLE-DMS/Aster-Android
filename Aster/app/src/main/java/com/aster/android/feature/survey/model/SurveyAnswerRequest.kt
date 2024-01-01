package com.aster.android.feature.survey.model

import com.aster.android.feature.survey.type.AnswerType
import com.aster.android.feature.survey.type.SurveyType

data class SurveyAnswerRequest(
    val surveyType: SurveyType,
    val answerType: AnswerType,
)
