package com.aster.android.network

import com.aster.android.feature.ranking.model.RankingResponse
import retrofit2.Response
import retrofit2.http.GET

interface SchoolClassApi {
    @GET("/aster/school-class/")
    suspend fun getRanking(
    ): Response<List<RankingResponse>>
}