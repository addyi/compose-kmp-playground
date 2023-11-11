package io.github.addyi.playground.apod.entities

import kotlin.jvm.JvmInline
import kotlinx.datetime.LocalDate

data class Apod(
    val title: Title,
    val description: Description,
    val apod: MediaType,
    val date: LocalDate,
    val copyrightOwner: CopyrightOwner?
)

sealed class MediaType {
    data class Image(val url: Url) : MediaType()
    data class Video(val url: Url) : MediaType()
}

@JvmInline
value class Url(val value: String)

@JvmInline
value class Title(val value: String)

@JvmInline
value class Description(val value: String)

@JvmInline
value class CopyrightOwner(val value: String)
