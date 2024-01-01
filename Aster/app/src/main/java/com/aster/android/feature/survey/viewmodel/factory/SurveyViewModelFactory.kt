package com.aster.android.feature.survey.viewmodel.factorysu

import android.content.SharedPreferences.Editor
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aster.android.feature.survey.repository.SurveyRepository
import com.aster.android.feature.survey.viewmodel.SurveyViewModel

@Suppress("UNCHECKED_CAST")
class SurveyViewModelFactory(
    private val surveyRepository: SurveyRepository,
    private val editor: Editor,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SurveyViewModel(surveyRepository, editor) as T
    }
}