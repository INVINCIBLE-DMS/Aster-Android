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

    private val detailRepository: DetailRepository by lazy {
        DetailRepository()
    }

    private val detailViewModelFactory: DetailViewModelFactory by lazy {
        DetailViewModelFactory(detailRepository, editor)
    }

    private val detailViewModel: DetailViewModel by lazy {
        ViewModelProvider(this, detailViewModelFactory)[DetailViewModel::class.java]
    }

    private var liked:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.lifecycleOwner = this
        val data = intent.extras?.getLong("feedId")
        if (data != null) {
            initData(data)
            initLikeBtn(data)
        }
        initBack()
        observeCommentList()
    }

    private fun initBack() {
        binding.ivDetailBack.setOnClickListener {
            finish()
        }
    }

    private fun initData(feedId: Long) {
        //val feedId = intent.extras?.getLong("feedId")
        detailViewModel.getCommentList(feedId)

    }

    private fun initLikeBtn(feedId: Long) {
        binding.btnDetailLike.setOnClickListener {
            liked = !liked
            likeBtn()
            detailViewModel.postLike(feedId)
        }
    }


    private fun observeCommentList() {
        detailViewModel.commentListResponse.observe(this) {
            when (it.code()) {
                OK -> {

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
            liked = data.liked
            btnDetailLike.text = "${data.likeCount}개"
            likeBtn()/*
            btnDetailLike.apply {
                text = "${data.likeCount}개"
                if (data.liked) {
                    setBackgroundColor(R.color.strong_pink)

                    val newDrawable = resources.getDrawable(R.drawable.feed_like_activation)
                    setCompoundDrawablesWithIntrinsicBounds(newDrawable, null, null, null)
                } else {
                    setBackgroundColor(R.color.light_gray)

                    val newDrawable = resources.getDrawable(R.drawable.feed_like_inactive)
                    setCompoundDrawablesWithIntrinsicBounds(newDrawable, null, null, null)
                }
            }*/
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun likeBtn() {
        binding.btnDetailLike.apply {
            //.setOnFocusChangeListener { _, hasFocus ->

        //}

            if(liked){

                val newDrawable = resources.getDrawable(R.drawable.feed_like_activation)
                setCompoundDrawablesWithIntrinsicBounds(newDrawable, null, null, null)
            }else {
                val newDrawable = resources.getDrawable(R.drawable.feed_like_inactive)
                setCompoundDrawablesWithIntrinsicBounds(newDrawable, null, null, null)
            }
        }
    }
}