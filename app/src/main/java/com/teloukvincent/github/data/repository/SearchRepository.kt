package com.teloukvincent.github.data.repository

import com.teloukvincent.github.data.api.UserApi
import com.teloukvincent.github.display.repository.UserRepository
import com.teloukvincent.github.search.UserDetail
import com.teloukvincent.github.search.UserShort
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class SearchRepository : UserRepository{


    private val retrofit: Retrofit

    init {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(UserApi.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val api = retrofit.create(UserApi::class.java)

    override suspend fun searchUser(id: String): List<UserShort> {
        return api.searchUser(id).map {
            it.toUserShort()
        }
    }

    fun UserShort.toUserShort() = UserShort(this.login, this.id, this.node_id, this.avatar_url, this.gravatar_id)
}

