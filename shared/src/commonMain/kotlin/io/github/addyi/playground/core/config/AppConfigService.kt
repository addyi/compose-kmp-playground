package io.github.addyi.playground.core.config

import kotlin.jvm.JvmInline

interface AppConfigService {
    val apodHost: ApodHost
    val apodApiKey: ApodApiKey
}

@JvmInline
value class ApodHost(val value: String)

@JvmInline
value class ApodApiKey(val value: String)
