package com.pvasilev.music.data

import android.media.MediaDescription
import android.support.v4.media.MediaDescriptionCompat

val EMPTY_DESCRIPTION: MediaDescription = MediaDescription.Builder().build()

fun MediaDescriptionCompat.isEmpty() = mediaDescription == EMPTY_DESCRIPTION