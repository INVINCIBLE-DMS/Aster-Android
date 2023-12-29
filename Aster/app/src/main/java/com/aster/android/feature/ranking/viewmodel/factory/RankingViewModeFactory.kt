package com.aster.android.feature.ranking.viewmodel.factory

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aster.android.feature.ranking.repository.RankingRepository
import com.aster.android.feature.ranking.viewmodel.RankingViewModel

@Suppress("UNCHECKED_CAST")
class RankingViewModeFactory(
    private val rankingRepository: RankingRepository,
    private val editor: SharedPreferences.Editor,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RankingViewModel(rankingRepository, editor) as T
    }
}