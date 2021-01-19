package com.teloukvincent.github.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
        @SerializedName("items")
        val users: List<UserRepoShort>,
        @SerializedName("total_count")
        val resultNumber: Int,
)