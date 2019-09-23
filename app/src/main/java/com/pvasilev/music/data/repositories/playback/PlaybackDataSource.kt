package com.pvasilev.music.data.repositories.playback

import android.support.v4.media.session.MediaControllerCompat
import android.support.v4.media.session.PlaybackStateCompat
import com.pvasilev.music.data.MediaControllerChangeEvent
import com.pvasilev.music.data.changeEvents
import io.reactivex.Observable
import javax.inject.Inject

interface PlaybackDataSource {
    fun getPlaybackState(): Observable<PlaybackStateCompat>
}

class PlaybackDataSourceImpl @Inject constructor(private val mediaController: MediaControllerCompat) : PlaybackDataSource {
    override fun getPlaybackState(): Observable<PlaybackStateCompat> {
        return mediaController.changeEvents()
            .filter { it is MediaControllerChangeEvent.PlaybackStateChange }
            .cast(MediaControllerChangeEvent.PlaybackStateChange::class.java)
            .map { it.playbackState }
    }
}