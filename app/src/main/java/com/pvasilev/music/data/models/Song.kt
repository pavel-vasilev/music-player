package com.pvasilev.music.data.models

import android.content.ContentUris
import android.net.Uri
import android.os.Parcelable
import android.provider.MediaStore
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Song(
    val id: Long,
    val name: String,
    val duration: Long,
    val albumId: Long
) : Parcelable {
    @IgnoredOnParcel
    val uri: Uri = ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id)
}