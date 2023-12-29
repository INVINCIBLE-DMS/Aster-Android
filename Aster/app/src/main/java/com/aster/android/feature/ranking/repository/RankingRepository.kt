package com.aster.android.feature.ranking.repository

import com.aster.android.feature.ranking.model.RankingResponse
import com.aster.android.network.schoolClassApi
import retrofit2.Response

class RankingRepository {

    suspend fun getRanking(
    ): Response<List<RankingResponse>> = schoolClassApi.getRanking()
}