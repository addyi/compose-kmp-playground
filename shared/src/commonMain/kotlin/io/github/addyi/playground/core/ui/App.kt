package io.github.addyi.playground.core.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.addyi.playground.apod.di.apodModule
import io.github.addyi.playground.apod.ui.ApodScreen
import io.github.addyi.playground.core.di.coreModule
import org.koin.compose.KoinApplication

@Composable
fun App() {
    KoinApplication(
        application = {
            modules(listOf(coreModule, apodModule))
        }
    ) {
        MaterialTheme {
            Scaffold(
                modifier = Modifier.fillMaxWidth(),
                topBar = {
                    TopAppBar(
                        modifier = Modifier.fillMaxWidth(),
                        title = { Text(text = "Hello, ${getPlatformName()}") }
                    )
                }
            ) {
                ApodScreen(
                    modifier = Modifier.padding(it)
                )
            }
        }
    }
}

expect fun getPlatformName(): String
