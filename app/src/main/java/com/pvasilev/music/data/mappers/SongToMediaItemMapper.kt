package com.pvasilev.music.data.mappers

import android.support.v4.media.MediaBrowserCompat.MediaItem
import android.support.v4.media.MediaDescriptionCompat
import com.pvasilev.music.data.models.Song

class SongToMediaItemMapper : Mapper<Song, MediaItem> {
    override fun map(song: Song): MediaItem {
        return MediaItem(
            MediaDescriptionCompat.Builder()
                .setMediaId("/songs/${song.id}")
                .setMediaUri(song.uri)
                .setTitle(song.name)
                .build(),
            MediaItem.FLAG_PLAYABLE
        )
    }

}