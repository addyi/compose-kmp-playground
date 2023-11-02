package io.github.addyi.playground.apod.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

object ApodScreen : Screen {

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        val screenModel = getScreenModel<ApodScreenModel>()
        val uiState by screenModel.state.collectAsState()

        val composableScope = rememberCoroutineScope()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { screenModel.fetchApod() },
                content = { Text("Load APOD") }
            )

            when (val state = uiState) {
                ApodScreenState.Init -> Unit
                ApodScreenState.Loading -> CircularProgressIndicator()

                is ApodScreenState.Success -> Text(
                    text = state.apod,
                    modifier = Modifier
                )

                is ApodScreenState.Error -> Text(
                    text = state.errorMsg,
                    modifier = Modifier
                )
            }

            Image(
                painterResource("compose-multiplatform.xml"),
                null
            )
        }
    }
}
