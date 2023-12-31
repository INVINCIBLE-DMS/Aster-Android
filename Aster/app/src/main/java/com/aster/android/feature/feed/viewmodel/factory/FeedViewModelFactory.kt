package com.aster.android.feature.feed.viewmodel.factory

import android.content.SharedPreferences.Editor
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aster.android.feature.feed.repository.FeedRepository
import com.aster.android.feature.feed.viewmodel.FeedViewModel

@Suppress("UNCHECKED_CAST")
class FeedViewModelFactory(
    private val feedRepository: FeedRepository,
    private val editor: Editor
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FeedViewModel(feedRepository,editor) as T
    }
}