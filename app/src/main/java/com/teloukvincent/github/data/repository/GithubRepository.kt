package com.teloukvincent.github.data.repository

import com.teloukvincent.github.data.api.UserApi
import com.teloukvincent.github.data.model.GithubUserShort
import com.teloukvincent.github.domain.model.RepoShort
import com.teloukvincent.github.domain.model.UserShort
import com.teloukvincent.github.domain.repository.GithubRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubRepository : GithubRepository {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(UserApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(UserApi::class.java)

    override suspend fun searchUser(search: String): List<UserShort> {
        return api.searchUser(search).users.map {
            it.toUserShort()
        }
    }

    override suspend fun getRepositories(login: String): List<RepoShort> {
        return api.getUserRepo(login).map {
            it.toRepoShort()
        }
    }
}

fun com.teloukvincent.github.data.model.UserRepoShort.toUserShort() = UserShort(this.id, this.login, this.avatar)

fun GithubUserShort.toRepoShort() = RepoShort(
    this.id,
    this.name,
    this.description,
    this.language,
    this.fork,
    this.watchers,
    this.license
)