package com.aster.android.feature.home.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.aster.android.R
import com.aster.android.base.BaseFragment
import com.aster.android.databinding.FragmentHomeBinding
import com.aster.android.feature.home.adapter.HomeViewPagerAdapter
import com.aster.android.feature.home.repository.HomeRepository
import com.aster.android.feature.home.viewmodel.HomeViewModel
import com.aster.android.feature.home.viewmodel.factory.HomeViewModelFactory
import com.aster.android.feature.survey.activity.SurveyActivity
import com.aster.android.util.OK
import com.bumptech.glide.Glide


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val homeRepository: HomeRepository by lazy {
        HomeRepository()
    }

    private val homeViewModelFactory: HomeViewModelFactory by lazy {
        HomeViewModelFactory(homeRepository, editor)
    }

    private val homeViewModel: HomeViewModel by lazy {
        ViewModelProvider(this, homeViewModelFactory)[HomeViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeFragment = this
        binding.homeViewModel = homeViewModel
        initMoveSurvey()
        initViewPager()
        observeMatching()
    }

    private fun initMoveSurvey() {
        binding.ivHomeCandy.setOnClickListener {
            val intent = Intent(context, SurveyActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initViewPager() {
        val adapter = HomeViewPagerAdapter(requireActivity())
        binding.vpHome.adapter = adapter
    }

    fun performSearch(text: String) {
        Log.d("TEST","a"+text)
        homeViewModel.getMatching((text))
    }

    private fun observeMatching() {
        homeViewModel.matchingResponse.observe(viewLifecycleOwner) {
            when(it.code()) {
                OK-> {
                    it.body()!!.apply {
                        binding.tvHomeName.text = "'${username}'님과의 궁합률은"
                        binding.tvHomePercent.text = "$matchScore%"
                        Glide.with(requireContext())
                            .load(profileImgUrl)
                            .into(binding.ivHomeProfile)
                    }
                }
            }
        }
    }

}