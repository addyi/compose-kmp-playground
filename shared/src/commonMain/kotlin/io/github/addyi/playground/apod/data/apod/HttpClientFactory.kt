package io.github.addyi.playground.apod.data.apod

import io.ktor.client.HttpClient

expect class HttpClientFactory() {
    fun create(): HttpClient
}
