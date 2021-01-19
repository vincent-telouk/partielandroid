package com.teloukvincent.github.data.api

import com.teloukvincent.github.search.UserDetail
import com.teloukvincent.github.search.UserShort
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApi {

    companion object {
        const val BASE_URL = "https://api.github.com/search/users"
    }

    @GET("/name")
    suspend fun searchUser(
        @Query("q") id: String,
        @Path("name") idUser: String,
    ) : List<UserShort>



}