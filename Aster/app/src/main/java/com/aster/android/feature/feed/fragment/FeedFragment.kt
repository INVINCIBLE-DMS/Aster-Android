package com.aster.android.feature.feed.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aster.android.R
import com.aster.android.base.BaseFragment
import com.aster.android.databinding.FragmentFeedBinding
import com.aster.android.feature.feed.adapter.FeedAdapter
import com.aster.android.feature.feed.model.FeedResponse
import com.aster.android.feature.feed.repository.FeedRepository
import com.aster.android.feature.feed.viewmodel.FeedViewModel
import com.aster.android.feature.feed.viewmodel.factory.FeedViewModelFactory
import com.aster.android.feature.write.activity.WriteActivity
import com.aster.android.util.OK

class FeedFragment : BaseFragment<FragmentFeedBinding>(R.layout.fragment_feed) {

    private val feedRepository:FeedRepository by lazy {
        FeedRepository()
    }

    private val feedViewModelFactory : FeedViewModelFactory by lazy {
        FeedViewModelFactory(feedRepository,editor)
    }

    private val feedViewModel : FeedViewModel by lazy {
        ViewModelProvider(this,feedViewModelFactory)[FeedViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.feedFragment = this
        binding.feedViewModel = feedViewModel
        initRecyclerView()
        initFeedData()
        moveWritePage()
        observeGetFeed()
    }

    private fun moveWritePage() {
        binding.floatFeed.setOnClickListener {
            val intent = Intent(context, WriteActivity::class.java)
            startActivity(intent)
        }
    }
    
    private fun initRecyclerView() {
        binding.rvFeed.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
    }

    private fun initFeedData() {
        feedViewModel.getFeedList()
    }

    private fun observeGetFeed() {
        feedViewModel.feedResponse.observe(viewLifecycleOwner) {
            when(it.code()) {
                OK-> {
                    setFeedData(it.body()!!)
                }
            }

        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setFeedData(dataList: List<FeedResponse>) {
        val adapter = FeedAdapter(dataList,requireContext())

        binding.rvFeed.adapter = adapter
        adapter.notifyDataSetChanged()
    }



}