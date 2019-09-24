package com.pvasilev.music.data.models

import android.content.ContentUris
import android.net.Uri
import android.provider.MediaStore

data class Song(
    val id: Long,
    val name: String,
    val albumId: Long
) {
    val uri: Uri = ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id)

    val albumArt: Uri = Uri.parse("content://media/external/audio/albumart/$albumId")
}