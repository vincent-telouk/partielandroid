package com.teloukvincent.github.data.api

import com.teloukvincent.github.data.model.SearchResponse
import com.teloukvincent.github.data.model.GithubUserShort
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApi {
    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    @GET("/search/users?q=google")
    suspend fun searchUser(
        @Query("q") login: String,
    ): SearchResponse

    @GET("/users/{login}/repos")
    suspend fun getUserRepo(
        @Path("login") login: String,
    ): List<GithubUserShort>
}