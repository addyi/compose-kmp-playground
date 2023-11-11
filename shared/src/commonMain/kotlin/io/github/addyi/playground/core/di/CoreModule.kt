package io.github.addyi.playground.core.di

import io.github.addyi.playground.core.config.AppConfigService
import io.github.addyi.playground.core.config.AppConfigServiceImpl
import org.koin.dsl.module

val coreModule = module {
    single<AppConfigService> { AppConfigServiceImpl() }
}
