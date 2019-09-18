package com.pvasilev.music.data.models

sealed class MediaSource

data class Album(
    val id: Long,
    val name: String,
    val artist: String
) : MediaSource()

data class Genre(
    val id: Long,
    val name: String
) : MediaSource()