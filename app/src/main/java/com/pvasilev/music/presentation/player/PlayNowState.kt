package com.pvasilev.music.presentation.player

import android.support.v4.media.session.PlaybackStateCompat
import com.airbnb.mvrx.MvRxState
import com.pvasilev.music.data.models.Song

data class PlayNowState(
    val currentSong: Song,
    val playbackState: PlaybackStateCompat
) : MvRxState {
    val isPlaying = playbackState.state == PlaybackStateCompat.STATE_PLAYING
    val isPaused = playbackState.state == PlaybackStateCompat.STATE_PAUSED
}