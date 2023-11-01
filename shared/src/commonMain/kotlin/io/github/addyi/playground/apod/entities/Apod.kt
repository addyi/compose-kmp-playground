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
value class Url(val url: String)

@JvmInline
value class Title(val title: String)

@JvmInline
value class Description(val description: String)

@JvmInline
value class CopyrightOwner(val copyright: String)
