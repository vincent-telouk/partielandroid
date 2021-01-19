package com.teloukvincent.github.presentation.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.teloukvincent.github.domain.repository.GithubRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: GithubRepository = com.teloukvincent.github.data.repository.GithubRepository()

    private val _state = MutableLiveData<DetailState>()
    val state: LiveData<DetailState> get() = _state

    fun getMovieDetail(id: String) {
        _state.value = DetailState.LoadingState

        viewModelScope.launch {
            try {
                _state.value = DetailState.SuccessState(repository.getRepositories(id))
            } catch (e: Exception) {
                _state.value = DetailState.ErrorState
            }
        }
    }
}