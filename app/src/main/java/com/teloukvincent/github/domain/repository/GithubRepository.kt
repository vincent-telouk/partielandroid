package com.teloukvincent.github.domain.repository

import com.teloukvincent.github.domain.model.RepoShort
import com.teloukvincent.github.domain.model.UserShort

interface GithubRepository {

    suspend fun searchUser(search: String): List<UserShort>

    suspend fun getRepositories(search: String): List<RepoShort>

}