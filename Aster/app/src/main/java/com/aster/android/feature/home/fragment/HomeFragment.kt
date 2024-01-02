package com.aster.android.feature.home.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.aster.android.R
import com.aster.android.base.BaseFragment
import com.aster.android.databinding.FragmentHomeBinding
import com.aster.android.feature.home.adapter.HomeViewPagerAdapter
import com.aster.android.feature.survey.activity.SurveyActivity


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeFragment = this
        //binding.homeViewModel =
        initMoveSurvey()
        initViewPager()
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

}