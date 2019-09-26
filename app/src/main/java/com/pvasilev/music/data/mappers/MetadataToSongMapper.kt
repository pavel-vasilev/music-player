package com.pvasilev.music.data.mappers

import android.content.ContentUris
import android.support.v4.media.MediaMetadataCompat
import com.pvasilev.music.data.models.Song
import javax.inject.Inject

class MetadataToSongMapper @Inject constructor() : Mapper<MediaMetadataCompat, Song> {
    override fun map(metadata: MediaMetadataCompat): Song {
        val description = metadata.description
        val id = ContentUris.parseId(description.mediaUri)
        val name = description.title.toString()
        val duration = metadata.getLong(MediaMetadataCompat.METADATA_KEY_DURATION)
        val albumId = ContentUris.parseId(description.iconUri)
        return Song(id, name, duration, albumId)
    }
}