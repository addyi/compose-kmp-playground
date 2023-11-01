package io.github.addyi.playground.apod.di

import io.github.addyi.playground.apod.data.apod.HttpClientFactory
import io.github.addyi.playground.apod.data.apod.KtorApodClient
import io.github.addyi.playground.apod.domain.apod.ApodClient
import org.koin.dsl.module

val apodModule = module {
    single { HttpClientFactory().create() }
    single<ApodClient> { KtorApodClient(get(), get()) }
}
