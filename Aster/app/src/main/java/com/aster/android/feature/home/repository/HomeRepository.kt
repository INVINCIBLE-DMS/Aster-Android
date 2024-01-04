package com.aster.android.feature.home.repository

import com.aster.android.feature.home.model.MatchingBothRequest
import com.aster.android.feature.home.model.MatchingBothResponse
import com.aster.android.feature.home.model.MatchingResponse
import com.aster.android.network.userApi
import retrofit2.Response

class HomeRepository {

    suspend fun getMatch(
        username: String
    ): Response<MatchingResponse> = userApi.getMatching(username)

    suspend fun getBothMatch(
        matchingBothRequest: MatchingBothRequest
    ): Response<MatchingBothResponse> = userApi.getMatchBoth(matchingBothRequest)
}