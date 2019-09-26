package com.pvasilev.music.data.models

import android.net.Uri

data class Album(
    val id: Long,
    val name: String,
    val artist: String
) {
    val art: Uri = Uri.parse("content://media/external/audio/albumart/$id")
}