package io.github.addyi.playground.apod.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import io.github.addyi.playground.apod.entities.CopyrightOwner
import io.github.addyi.playground.apod.entities.Description
import io.github.addyi.playground.apod.entities.MediaType
import io.github.addyi.playground.apod.entities.Title
import kotlinx.datetime.LocalDate

object ApodScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = getScreenModel<ApodScreenModel>()
        val uiState by screenModel.state.collectAsState()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            when (val state = uiState) {
                ApodScreenState.Init -> Initial(
                    modifier = Modifier
                        .align(Alignment.Center),
                    onClick = screenModel::fetchApod
                )

                ApodScreenState.Loading -> Loading(
                    modifier = Modifier
                        .align(Alignment.Center)
                )

                is ApodScreenState.Success.ApodImage -> ApodImage(
                    title = state.title,
                    description = state.description,
                    apod = state.apod,
                    date = state.date,
                    copyrightOwner = state.copyrightOwner,
                    modifier = Modifier
                )

                is ApodScreenState.Success.ApodVideo -> TODO() // Fixme implement

                is ApodScreenState.Error -> Error(
                    modifier = Modifier.align(Alignment.Center),
                    onTryAgain = screenModel::fetchApod,
                    errorMsg = state.errorMsg
                )
            }
        }
    }

    @Composable
    private fun ApodImage(
        title: Title,
        description: Description,
        apod: MediaType.Image,
        date: LocalDate,
        copyrightOwner: CopyrightOwner?,
        modifier: Modifier = Modifier
    ) {
        Text(
            modifier = modifier,
            text = "$date = $title"
        )

        // fixme show image
    }

    @Composable
    private fun Error(
        onTryAgain: () -> Unit,
        errorMsg: String,
        modifier: Modifier = Modifier
    ) {
        // FIXME retry button and illustration

        Text(
            text = errorMsg,
            modifier = modifier
        )
    }

    @Composable
    private fun Initial(
        onClick: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        Button(
            modifier = modifier,
            onClick = onClick,
            content = { Text("Load APOD") } // FIXME extract string resource
        )
    }

    @Composable
    private fun Loading(
        modifier: Modifier = Modifier
    ) {
        CircularProgressIndicator(modifier = modifier)
    }
}
