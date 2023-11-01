package io.github.addyi.playground.apod.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.github.addyi.playground.apod.domain.apod.ApodClient
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ApodScreen(
    modifier: Modifier = Modifier,
    apodClient: ApodClient = koinInject()
) {
    var apodText by remember { mutableStateOf("") }

    val composableScope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                composableScope.launch {
                    apodText = apodClient.getApod(null).toString()
                }
            },
            content = { Text("Load APOD") }
        )

        Text(
            text = apodText,
            modifier = Modifier
        )

        Image(
            painterResource("compose-multiplatform.xml"),
            null
        )
    }
}
