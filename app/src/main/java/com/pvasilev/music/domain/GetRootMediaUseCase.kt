package com.pvasilev.music.domain

import android.content.Context
import android.support.v4.media.MediaBrowserCompat.MediaItem
import android.support.v4.media.MediaDescriptionCompat
import com.pvasilev.music.R

interface GetRootMediaUseCase {
    operator fun invoke(): List<MediaItem>
}

class GetRootMediaUseCaseImpl(private val context: Context) : GetRootMediaUseCase {
    override fun invoke(): List<MediaItem> {
        return listOf(
            MediaItem(
                MediaDescriptionCompat.Builder()
                    .setMediaId(GetMediaUseCase.ALBUMS_MEDIA_ID)
                    .setTitle(context.resources.getString(R.string.title_albums))
                    .build(),
                MediaItem.FLAG_BROWSABLE
            ),
            MediaItem(
                MediaDescriptionCompat.Builder()
                    .setMediaId(GetMediaUseCase.GENRES_MEDIA_ID)
                    .setTitle(context.resources.getString(R.string.title_genres))
                    .build(),
                MediaItem.FLAG_BROWSABLE
            )
        )
    }
}