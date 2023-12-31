package com.aster.android.feature.detail.viewmodel.factory

import android.content.SharedPreferences.Editor
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aster.android.feature.detail.repository.DetailRepository
import com.aster.android.feature.detail.viewmodel.DetailViewModel

@Suppress("UNCHECKED_CAST")
class DetailViewModelFactory(
    private val detailRepository: DetailRepository,
    private val editor: Editor
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(detailRepository, editor) as T
    }
}