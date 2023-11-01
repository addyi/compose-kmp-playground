package io.github.addyi.playground.apod.domain.apod

import arrow.core.Either
import io.github.addyi.playground.apod.entities.Apod
import kotlinx.datetime.LocalDate

interface ApodClient {

    suspend fun getApod(date: LocalDate?): Either<ApodError, Apod>
}
