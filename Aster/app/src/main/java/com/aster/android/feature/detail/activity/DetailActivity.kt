package com.aster.android.feature.detail.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.aster.android.R
import com.aster.android.base.BaseActivity
import com.aster.android.databinding.ActivityDetailBinding
import com.aster.android.feature.detail.model.FeedResponse
import com.aster.android.feature.detail.repository.DetailRepository
import com.aster.android.feature.detail.viewmodel.DetailViewModel
import com.aster.android.feature.detail.viewmodel.factory.DetailViewModelFactory
import com.aster.android.util.OK
import com.bumptech.glide.Glide

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
        initBack()
        initData()
        observeCommentList()
    }

    private fun initBack() {
        binding.ivDetailBack.setOnClickListener {
            finish()
        }
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

                    setFeedData(it.body()!!.feedResponse)
                }
            }
        }

    }

    @SuppressLint("ResourceAsColor")
    private fun setFeedData(data: FeedResponse) {
        binding.apply {
            Glide
                .with(baseContext)
                .load(data.profileImgUrl)
                .into(ivDetailProfile)
            tvDetailWriter.text = data.username
            tvDetailDate.text = data.createdAt
            tvDetailTitle.text = data.title
            tvDetailContent.text = data.content
            btnDetailLike.apply {
                text = "${data.likeCount}개"
                if(data.liked) {
                    setBackgroundColor(R.color.strong_pink)
                    setBackgroundResource(R.drawable.feed_like_activation)

                }else {
                    setBackgroundColor(R.color.light_gray)
                    setBackgroundResource(R.drawable.feed_like_inactive)
                }
            }
        }
    }
}