package com.aster.android.network

import com.aster.android.BuildConfig
import com.aster.android.util.ACCESS_TOKEN
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private lateinit var retrofit: Retrofit

    fun getRetrofit(): Retrofit {
        retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            //.addCallAdapterFactory() //rxjava
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        RequestInterceptor()
                    )
                    .build()
            )
            .build()
        return retrofit
    }
}

class RequestInterceptor : Interceptor {
    private lateinit var request: Request
    override fun intercept(chain: Interceptor.Chain): Response {
        val ignorePath = arrayListOf(
            "/users/login",
            "/aster/auth",
            "/aster/feed",
            "/aster/school-class"
        )
        request = if (ignorePath.contains(chain.request().url().encodedPath()))
            chain.request().newBuilder().build()
        else
            chain.request().newBuilder().addHeader(
                "Authorization",
                "Bearer $ACCESS_TOKEN",
            ).build()

        return chain.proceed(request)
    }
}
