package com.teloukvincent.github.search

import com.google.gson.annotations.SerializedName

data class UserShort (
    @SerializedName("login")
    val login: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("node_id")
    val node_id: String,
    @SerializedName("avatar_url")
    val avatar_url: String,
    @SerializedName("gravatar_id")
    val gravatar_id: String,


    )

