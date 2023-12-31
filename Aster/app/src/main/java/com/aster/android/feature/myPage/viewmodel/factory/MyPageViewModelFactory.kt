package com.aster.android.feature.myPage.viewmodel.factory

import android.content.SharedPreferences.Editor
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aster.android.feature.myPage.repository.MyPageRepository
import com.aster.android.feature.myPage.viewmodel.MyPageViewModel

@Suppress("UNCHECKED_CAST")
class MyPageViewModelFactory(
    private val myPageRepository: MyPageRepository,
    private val editor: Editor,
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyPageViewModel(myPageRepository,editor) as T
    }
}