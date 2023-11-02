package io.github.addyi.playground.apod.ui

sealed class ApodScreenState {
    data object Init : ApodScreenState()
    data object Loading : ApodScreenState()
    data class Error(val errorMsg: String) : ApodScreenState()
    data class Success(val apod: String) : ApodScreenState()
}
