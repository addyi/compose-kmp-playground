package io.github.addyi.playground.apod.data.apod

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

actual class HttpClientFactory actual constructor() {
    actual fun create(): HttpClient {
        return HttpClient(Android) {
            install(ContentNegotiation) {
                json()
            }
        }
    }
}
