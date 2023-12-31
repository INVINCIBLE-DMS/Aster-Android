package com.aster.android.feature.myPage.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.aster.android.R
import com.aster.android.base.BaseFragment
import com.aster.android.databinding.FragmentMyPageBinding
import com.aster.android.feature.myPage.model.MyPageResponse
import com.aster.android.feature.myPage.repository.MyPageRepository
import com.aster.android.feature.myPage.viewmodel.MyPageViewModel
import com.aster.android.feature.myPage.viewmodel.factory.MyPageViewModelFactory
import com.aster.android.util.OK
import com.bumptech.glide.Glide

class MyPageFragment : BaseFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {

    private val myPageRepository: MyPageRepository by lazy {
        MyPageRepository()
    }

    private val myPageViewModelFactory: MyPageViewModelFactory by lazy {
        MyPageViewModelFactory(myPageRepository,editor)
    }

    private val myPageViewModel : MyPageViewModel by lazy {
        ViewModelProvider(this,myPageViewModelFactory)[MyPageViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.myPageFragment = this
        binding.myPageViewModel = myPageViewModel
        initData()
        observeGetMyInfo()
    }

    private fun initData() {
        myPageViewModel.getMyInfo()
    }

    private fun observeGetMyInfo() {
        myPageViewModel.myPageResponse.observe(viewLifecycleOwner) {
            when(it.code()) {
                OK-> {
                    setData(it.body()!!)
                }
            }
        }
    }

    private fun setData(data: MyPageResponse) {
        val candyCount = data.classCandyCount
        binding.tvMyPageName.text = data.username
        binding.tvMyPageGrade.text = data.studentId
        binding.ivMyPageProfile
        Glide
            .with(requireContext())
            .load(data.profileImageUrl)
            .into(binding.ivMyPageProfile)
        binding.tvMyPageCandyCount.text = "$candyCount 개"

    }

}