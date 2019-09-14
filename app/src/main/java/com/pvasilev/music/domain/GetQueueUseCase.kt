package com.pvasilev.music.domain

import android.support.v4.media.MediaBrowserCompat.MediaItem
import android.support.v4.media.session.MediaSessionCompat.QueueItem
import com.pvasilev.music.data.mappers.Mapper
import javax.inject.Inject

interface GetQueueUseCase {
    operator fun invoke(mediaId: String): List<QueueItem>
}

class GetQueueUseCaseImpl @Inject constructor(
    private val getMedia: GetMediaUseCase,
    private val mapper: Mapper<MediaItem, QueueItem>
) : GetQueueUseCase {
    override fun invoke(mediaId: String): List<QueueItem> {
        return getMedia(mediaId).map(mapper::map)
    }
}