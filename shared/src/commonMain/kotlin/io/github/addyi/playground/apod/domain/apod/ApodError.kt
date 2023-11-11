package io.github.addyi.playground.apod.domain.apod

sealed class ApodError {
    data class Network(val message: String) : ApodError()
    data class Client(val message: String) : ApodError()
    data class Server(val message: String) : ApodError()
    data class Unknown(val message: String) : ApodError()
}
