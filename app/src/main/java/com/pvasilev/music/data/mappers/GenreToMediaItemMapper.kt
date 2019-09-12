package com.pvasilev.music.data.mappers

import android.support.v4.media.MediaBrowserCompat.MediaItem
import android.support.v4.media.MediaDescriptionCompat
import com.pvasilev.music.data.models.Genre

class GenreToMediaItemMapper : Mapper<Genre, MediaItem> {
    override fun map(genre: Genre): MediaItem {
        return MediaItem(
            MediaDescriptionCompat.Builder()
                .setMediaId("/genres/${genre.id}")
                .setTitle(genre.name)
                .build(),
            MediaItem.FLAG_BROWSABLE
        )
    }
}