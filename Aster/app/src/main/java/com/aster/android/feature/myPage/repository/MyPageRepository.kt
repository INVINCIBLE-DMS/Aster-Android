package com.aster.android.feature.myPage.repository

import com.aster.android.feature.myPage.model.MyPageResponse
import com.aster.android.network.userApi
import com.aster.android.util.ACCESS_TOKEN
import retrofit2.Response

class MyPageRepository {

    suspend fun getMyInfo(
    ): Response<MyPageResponse> = userApi.getMyPage(ACCESS_TOKEN)
}