package io.github.addyi.playground.apod.ui

import arrow.core.Either
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import io.github.addyi.playground.apod.domain.apod.ApodClient
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ApodScreenModel(
    private val apodClient: ApodClient
) : StateScreenModel<ApodScreenState>(ApodScreenState.Init) {

    fun fetchApod() {
        screenModelScope.launch {
            mutableState.value = ApodScreenState.Loading

            delay(5000) // fixme remove again

            mutableState.value = when (val apod = apodClient.getApod(null)) {
                is Either.Left -> ApodScreenState.Error(apod.value.toString())
                is Either.Right -> ApodScreenState.Success("${apod.value.date} = ${apod.value.title.title}")
            }
        }
    }

    override fun onDispose() {
        // TODO: dispose
        super.onDispose()
    }
}
