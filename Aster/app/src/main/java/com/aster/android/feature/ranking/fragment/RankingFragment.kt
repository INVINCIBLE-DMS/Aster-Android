package com.aster.android.feature.ranking.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aster.android.R
import com.aster.android.base.BaseFragment
import com.aster.android.databinding.FragmentRankingBinding
import com.aster.android.feature.ranking.adapter.RankingAdapter
import com.aster.android.feature.ranking.model.RankingResponse
import com.aster.android.feature.ranking.repository.RankingRepository
import com.aster.android.feature.ranking.viewmodel.RankingViewModel
import com.aster.android.feature.ranking.viewmodel.factory.RankingViewModeFactory
import com.aster.android.util.OK


class RankingFragment : BaseFragment<FragmentRankingBinding>(R.layout.fragment_ranking) {

    private val rankingRepository: RankingRepository by lazy {
        RankingRepository()
    }

    private val rankingViewModeFactory: RankingViewModeFactory by lazy {
        RankingViewModeFactory(rankingRepository, editor)
    }

    private val rankingViewModel: RankingViewModel by lazy {
        ViewModelProvider(this, rankingViewModeFactory)[RankingViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rankingFragment = this
        binding.rankingViewModel = rankingViewModel
        initRecyclerView()
        initRankingData()
        observeGetRanking()
    }

    private fun initRankingData() {
        rankingViewModel.getRanking()
    }

    private fun observeGetRanking() {
        rankingViewModel.rankingResponse.observe(viewLifecycleOwner) {
            when (it.code()) {
                OK -> {
                    setTopRank(it.body()!!)
                    setRankingData(it.body()!!)
                }
            }
        }
    }

    private fun setTopRank(dataList: List<RankingResponse>) {
        when (dataList.size) {
            0 -> setTopContent(
                binding.tvRankingFirst,
                dataList[0].grade,
                dataList[0].classNumber,
                dataList[0].candyCount
            )
            1-> setTopContent(
                binding.tvRankingSecond,
                dataList[1].grade,
                dataList[1].classNumber,
                dataList[1].candyCount
            )
            2-> setTopContent(
                binding.tvRankingThird,
                dataList[2].grade,
                dataList[2].classNumber,
                dataList[2].candyCount
            )
        }
    }

    private fun setTopContent(
        gradeClass: TextView,
        grade: Long,
        classNum: Long,
        candyCnt: Int
    ) {
        gradeClass.text = "$grade - $classNum"
    }

    private fun setRankingData(dataList: List<RankingResponse>) {
        val adapter = RankingAdapter(dataList, requireContext())

        binding.rvRanking.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun initRecyclerView() {
        binding.rvRanking.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

}