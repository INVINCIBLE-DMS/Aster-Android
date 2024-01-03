package com.aster.android.feature.home.repository

import com.aster.android.feature.home.model.MatchingBothRequest
import com.aster.android.feature.home.model.MatchingBothResponse
import com.aster.android.feature.home.model.MatchingRequest
import com.aster.android.feature.home.model.MatchingResponse
import com.aster.android.network.userApi
import retrofit2.Response

class HomeRepository {

    suspend fun getMatch(
        matchingRequest: MatchingRequest
    ): Response<MatchingResponse> = userApi.getMatching(matchingRequest)

    suspend fun getBothMatch(
        matchingBothRequest: MatchingBothRequest
    ): Response<MatchingBothResponse> = userApi.getMatchBoth(matchingBothRequest)
}