package com.pvasilev.music.data.mappers

import android.support.v4.media.MediaBrowserCompat.MediaItem
import android.support.v4.media.MediaDescriptionCompat
import com.pvasilev.music.data.models.Album

class AlbumToMediaItemMapper : Mapper<Album, MediaItem> {
    override fun map(album: Album): MediaItem {
        return MediaItem(
            MediaDescriptionCompat.Builder()
                .setMediaId("/albums/${album.id}")
                .setTitle(album.name)
                .build(),
            MediaItem.FLAG_BROWSABLE
        )
    }
}