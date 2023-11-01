package io.github.addyi.playground.core.config

import io.github.addyi.playground.BuildKonfig

class AppConfigServiceImpl : AppConfigService {
    override val apodHost = ApodHost(BuildKonfig.apodHost)
    override val apodApiKey = ApodApiKey(BuildKonfig.apodApiKey)
}
