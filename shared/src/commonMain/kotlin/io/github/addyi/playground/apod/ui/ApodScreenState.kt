package io.github.addyi.playground.apod.ui

import io.github.addyi.playground.apod.entities.CopyrightOwner
import io.github.addyi.playground.apod.entities.Description
import io.github.addyi.playground.apod.entities.MediaType
import io.github.addyi.playground.apod.entities.Title
import kotlinx.datetime.LocalDate

sealed class ApodScreenState {
    data object Init : ApodScreenState()

    data object Loading : ApodScreenState()

    data class Error(val errorMsg: String) : ApodScreenState()

    sealed class Success : ApodScreenState() {
        data class ApodImage(
            val title: Title,
            val description: Description,
            val apod: MediaType.Image,
            val date: LocalDate,
            val copyrightOwner: CopyrightOwner?
        ) : Success()

        data class ApodVideo(
            val title: Title,
            val description: Description,
            val onOpenVideo: () -> Unit,
            val date: LocalDate,
            val copyrightOwner: CopyrightOwner?
        ) : Success()
    }
}
