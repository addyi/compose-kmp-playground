package io.github.addyi.playground.core.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
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
        MaterialTheme { // TODO create custom theme
            Navigator(ApodScreen) { navigator ->
                Scaffold(
                    modifier = Modifier.fillMaxWidth(),
                    topBar = {
                        TopAppBar(
                            modifier = Modifier.fillMaxWidth(),
                            title = { Text(text = "Hello, ${getPlatformName()}") }
                        )
                    }
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        CurrentScreen()
                    }
                }
            }
        }
    }
}

expect fun getPlatformName(): String
