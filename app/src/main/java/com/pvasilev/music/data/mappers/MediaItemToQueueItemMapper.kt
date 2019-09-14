package com.pvasilev.music.data.mappers

import android.support.v4.media.MediaBrowserCompat.MediaItem
import android.support.v4.media.session.MediaSessionCompat.QueueItem
import javax.inject.Inject

class MediaItemToQueueItemMapper @Inject constructor(): Mapper<MediaItem, QueueItem> {
    override fun map(item: MediaItem): QueueItem {
        return QueueItem(item.description, item.mediaId?.hashCode()?.toLong() ?: 0)
    }
}