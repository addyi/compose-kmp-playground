package io.github.addyi.playground.apod.data.apod

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import io.github.addyi.playground.apod.domain.apod.ApodClient
import io.github.addyi.playground.apod.domain.apod.ApodError
import io.github.addyi.playground.apod.entities.Apod
import io.github.addyi.playground.core.Config
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.path
import io.ktor.utils.io.errors.IOException
import kotlinx.datetime.LocalDate

class KtorApodClient(private val httpClient: HttpClient) : ApodClient {

    override suspend fun getApod(date: LocalDate?): Either<ApodError, Apod> {
        val response = try {
            httpClient.get {
                contentType(ContentType.Application.Json)
                url {
                    protocol = URLProtocol.HTTPS
                    host = Config.apodHost
                    path("/planetary/apod")
                    parameters.append("api_key", Config.apodApiKey)
                }
            }
        } catch (e: IOException) {
            return ApodError.Network(e.toString()).left()
        }

        when (response.status.value) {
            in 200..299 -> Unit // Happy path
            in 300..499 -> return ApodError.Client(response.status.toString()).left()
            in 500..599 -> return ApodError.Server(response.status.toString()).left()
            else -> return ApodError.Unknown("Undefined Status Code").left()
        }

        return try {
            response
                .body<ApodResponseDto>()
                .toApod()
                .getOrElse { return ApodError.Client("Result mapping failed with $it").left() }
                .right()
        } catch (e: Exception) {
            return ApodError.Client("Result mapping failed with $e").left()
        }
    }
}
