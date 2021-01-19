package com.teloukvincent.github.display.repository

import com.teloukvincent.github.search.UserDetail
import com.teloukvincent.github.search.UserShort

interface UserRepository {


    suspend fun searchUser(search : String) : List<UserShort>

    suspend fun getUserDetail(id :String) : UserDetail

}