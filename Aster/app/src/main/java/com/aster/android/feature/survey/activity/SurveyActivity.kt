package com.aster.android.feature.survey.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.aster.android.R
import com.aster.android.base.BaseActivity
import com.aster.android.databinding.ActivitySurveyBinding
import com.aster.android.feature.survey.repository.SurveyRepository
import com.aster.android.feature.survey.viewmodel.SurveyViewModel
import com.aster.android.feature.survey.viewmodel.factorysu.SurveyViewModelFactory
import com.aster.android.util.OK

class SurveyActivity : BaseActivity<ActivitySurveyBinding>(R.layout.activity_survey) {

    private val surveyRepository:SurveyRepository by lazy {
        SurveyRepository()
    }

    private val surveyViewModelFactory: SurveyViewModelFactory by lazy {
        SurveyViewModelFactory(surveyRepository,editor)
    }

    private val surveyViewModel: SurveyViewModel by lazy {
        ViewModelProvider(this,surveyViewModelFactory)[SurveyViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.surveyActivity = this
        initGetData()
        observeSurveyShow()
    }

    private fun initGetData() {
        surveyViewModel.surveyShow()
    }

    private fun observeSurveyShow() {
        surveyViewModel.surveyShowResponse.observe(this) {
            when(it.code()) {
                OK-> {

                }
            }
        }
    }
}