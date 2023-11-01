package io.github.addyi.playground.apod.data.apod

import arrow.core.raise.result
import io.github.addyi.playground.apod.entities.Apod
import io.github.addyi.playground.apod.entities.CopyrightOwner
import io.github.addyi.playground.apod.entities.Description
import io.github.addyi.playground.apod.entities.MediaType
import io.github.addyi.playground.apod.entities.Title
import io.github.addyi.playground.apod.entities.Url
import kotlinx.datetime.toLocalDate
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ApodResponseDto(
    @SerialName("title")
    val title: String,
    @SerialName("date")
    val date: String,
    @SerialName("url")
    val url: String,
    @SerialName("hdurl")
    val hdUrl: String,
    @SerialName("explanation")
    val explanation: String,
    @SerialName("copyright")
    val copyright: String? = null,
    @SerialName("media_type")
    val mediaType: String,
    @SerialName("service_version")
    val serviceVersion: String
)

fun ApodResponseDto.toApod() = result {
    val mediaUrl = hdUrl.ifBlank { url }

    val apod = when (mediaType) {
        "image" -> MediaType.Image(Url(mediaUrl))
        "video" -> MediaType.Video(Url(mediaUrl))
        else -> raise(IllegalArgumentException("Unknown media type: $mediaType"))
    }

    Apod(
        title = Title(title),
        description = Description(explanation),
        apod = apod,
        date = date.toLocalDate(),
        copyrightOwner = copyright?.let { CopyrightOwner(it) }
    )
}
