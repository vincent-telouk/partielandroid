package com.teloukvincent.github.presentation.detail

import com.teloukvincent.github.domain.model.RepoShort

sealed class DetailState {
    class SuccessState(val repos:List<RepoShort>) : DetailState()

    object ErrorState : DetailState()

    object LoadingState : DetailState()
}