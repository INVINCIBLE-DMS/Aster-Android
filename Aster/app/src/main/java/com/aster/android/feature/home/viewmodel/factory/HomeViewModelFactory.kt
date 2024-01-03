package com.aster.android.feature.home.viewmodel.factory

import android.content.SharedPreferences.Editor
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aster.android.feature.home.repository.HomeRepository
import com.aster.android.feature.home.viewmodel.HomeViewModel

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory(
    private val homeRepository: HomeRepository,
    private val editor: Editor,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(homeRepository, editor) as T
    }
}