package com.pvasilev.music.domain

import android.support.v4.media.session.PlaybackStateCompat
import com.pvasilev.music.data.repositories.playback.PlaybackDataSource
import io.reactivex.Observable
import javax.inject.Inject

interface GetPlaybackStateUseCase {
    operator fun invoke(): Observable<PlaybackStateCompat>
}

class GetPlaybackStateUseCaseImpl @Inject constructor(private val dataSource: PlaybackDataSource) : GetPlaybackStateUseCase {
    override fun invoke(): Observable<PlaybackStateCompat> {
        return dataSource.getPlaybackState()
    }
}