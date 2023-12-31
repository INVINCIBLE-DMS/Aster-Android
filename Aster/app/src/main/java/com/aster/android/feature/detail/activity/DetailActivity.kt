package com.aster.android.feature.detail.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.aster.android.R
import com.aster.android.base.BaseActivity
import com.aster.android.databinding.ActivityDetailBinding
import com.aster.android.feature.detail.repository.DetailRepository
import com.aster.android.feature.detail.viewmodel.DetailViewModel
import com.aster.android.feature.detail.viewmodel.factory.DetailViewModelFactory
import com.aster.android.util.OK

class DetailActivity : BaseActivity<ActivityDetailBinding>(R.layout.activity_detail) {

    private val detailRepository:DetailRepository by lazy {
        DetailRepository()
    }

    private val detailViewModelFactory:DetailViewModelFactory by lazy {
        DetailViewModelFactory(detailRepository,editor)
    }

    private val detailViewModel: DetailViewModel by lazy {
        ViewModelProvider(this,detailViewModelFactory)[DetailViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.lifecycleOwner = this
        initData()
        observeCommentList()
    }

    private fun initData() {
        val feedId = intent.extras?.getLong("feedId")
        if(feedId!= null) {
            detailViewModel.getCommentList(feedId)
        }
    }


    private fun observeCommentList() {
        detailViewModel.commentListResponse.observe(this) {
            when(it.code()) {
                OK-> {

                }
            }
        }

    }
}