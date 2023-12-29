package com.aster.android.feature.ranking.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.aster.android.R
import com.aster.android.base.BaseFragment
import com.aster.android.databinding.FragmentRankingBinding
import com.aster.android.feature.ranking.repository.RankingRepository
import com.aster.android.feature.ranking.viewmodel.RankingViewModel
import com.aster.android.feature.ranking.viewmodel.factory.RankingViewModeFactory


class RankingFragment : BaseFragment<FragmentRankingBinding>(R.layout.fragment_ranking) {

    private val rankingRepository:RankingRepository by lazy {
        RankingRepository()
    }

    private val rankingViewModeFactory: RankingViewModeFactory by lazy {
        RankingViewModeFactory(rankingRepository,editor)
    }

    private val rankingViewModel:RankingViewModel by lazy {
        ViewModelProvider(this,rankingViewModeFactory)[RankingViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rankingFragment = this
        binding.rankingViewModel = rankingViewModel
    }

}