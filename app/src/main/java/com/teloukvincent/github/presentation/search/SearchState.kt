package com.teloukvincent.github.presentation.search

import com.teloukvincent.github.domain.model.UserShort

sealed class SearchState {
    class SuccessState(val users:List<UserShort>) : SearchState()

    object ErrorState : SearchState()

    object LoadingState : SearchState()
}
