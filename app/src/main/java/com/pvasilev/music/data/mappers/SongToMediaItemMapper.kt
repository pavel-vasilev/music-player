package com.pvasilev.music.data.mappers

import android.support.v4.media.MediaBrowserCompat.MediaItem
import android.support.v4.media.MediaDescriptionCompat
import android.support.v4.media.MediaMetadataCompat
import androidx.core.os.bundleOf
import com.pvasilev.music.data.models.Song
import javax.inject.Inject

class SongToMediaItemMapper @Inject constructor() : Mapper<Song, MediaItem> {
    override fun map(song: Song): MediaItem {
        return MediaItem(
            MediaDescriptionCompat.Builder()
                .setMediaId("/songs/${song.id}")
                .setMediaUri(song.uri)
                .setIconUri(song.albumArt)
                .setTitle(song.name)
                .setExtras(bundleOf(MediaMetadataCompat.METADATA_KEY_DURATION to song.duration))
                .build(),
            MediaItem.FLAG_PLAYABLE
        )
    }

}