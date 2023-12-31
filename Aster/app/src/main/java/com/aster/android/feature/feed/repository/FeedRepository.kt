package com.aster.android.feature.feed.repository

import com.aster.android.feature.feed.model.FeedResponse
import com.aster.android.network.feedApi
import retrofit2.Response

class FeedRepository {

    suspend fun getFeed(
    ):Response<List<FeedResponse>> = feedApi.getFeedList()
}