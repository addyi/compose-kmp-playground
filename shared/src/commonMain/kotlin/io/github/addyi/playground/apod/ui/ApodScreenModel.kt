package io.github.addyi.playground.apod.ui

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import io.github.addyi.playground.apod.domain.apod.ApodClient
import io.github.addyi.playground.apod.domain.apod.ApodError
import io.github.addyi.playground.apod.entities.Apod
import io.github.addyi.playground.apod.entities.MediaType
import io.github.addyi.playground.apod.ui.ApodScreenState.Error
import io.github.addyi.playground.apod.ui.ApodScreenState.Success
import io.github.addyi.playground.apod.ui.ApodScreenState.Success.ApodImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ApodScreenModel(
    private val apodClient: ApodClient
) : StateScreenModel<ApodScreenState>(ApodScreenState.Init) {

    fun fetchApod() {
        screenModelScope.launch {
            mutableState.value = ApodScreenState.Loading

            delay(5000) // fixme remove again

            mutableState.value = apodClient.getApod(null).fold<ApodScreenState>(
                ifLeft = { error: ApodError -> error.toScreenState() },
                ifRight = { apod: Apod -> apod.toScreenState() }
            )
        }
    }

    private fun Apod.toScreenState(): Success {
        return when (apod) {
            is MediaType.Image -> ApodImage(
                title = this.title,
                description = description,
                apod = apod,
                date = date,
                copyrightOwner = copyrightOwner
            )

            is MediaType.Video -> TODO() // fixme implement video
        }
    }

    private fun ApodError.toScreenState(): Error {
        return when (this) {
            is ApodError.Client -> Error(this.message)
            is ApodError.Network -> Error(this.message)
            is ApodError.Server -> Error(this.message)
            is ApodError.Unknown -> Error(this.message)
        }
    }
}
