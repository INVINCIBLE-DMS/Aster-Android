package com.aster.android.network

val authApi : AuthApi by lazy {
    RetrofitClient.getRetrofit().create(AuthApi::class.java)
}

val usersApi : UsersApi by lazy {
    RetrofitClient.getRetrofit().create(UsersApi::class.java)
}

val userApi : UserApi by lazy {
    RetrofitClient.getRetrofit().create(UserApi::class.java)
}

val feedApi : FeedApi by lazy {
    RetrofitClient.getRetrofit().create(FeedApi::class.java)
}

val imageApi : ImageApi by lazy {
    RetrofitClient.getRetrofit().create(ImageApi::class.java)
}

val surveyStorageApi : SurveyStorageApi by lazy {
    RetrofitClient.getRetrofit().create(SurveyStorageApi::class.java)
}

val commentApi : CommentApi by lazy {
    RetrofitClient.getRetrofit().create(CommentApi::class.java)
}

val coCommentApi : CoCommentApi by lazy {
    RetrofitClient.getRetrofit().create(CoCommentApi::class.java)
}

val schoolClassApi : SchoolClassApi by lazy {
    RetrofitClient.getRetrofit().create(SchoolClassApi::class.java)
}

val likeApi : LikeApi by lazy {
    RetrofitClient.getRetrofit().create(LikeApi::class.java)
}

val commentLikeApi : CommentLikeApi by lazy {
    RetrofitClient.getRetrofit().create(CommentLikeApi::class.java)
}