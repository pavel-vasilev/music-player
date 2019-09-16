package com.pvasilev.music.media

import android.support.v4.media.MediaDescriptionCompat
import android.support.v4.media.session.MediaSessionCompat
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.Timeline
import com.google.android.exoplayer2.ext.mediasession.TimelineQueueNavigator
import javax.inject.Inject

class QueueNavigator @Inject constructor(mediaSession: MediaSessionCompat) : TimelineQueueNavigator(mediaSession) {
    private companion object {
        val DEFAULT_DESCRIPTION: MediaDescriptionCompat = MediaDescriptionCompat.Builder().build()
    }

    private val window = Timeline.Window()

    override fun getMediaDescription(player: Player, windowIndex: Int): MediaDescriptionCompat {
        val currentWindow = player.currentTimeline.getWindow(windowIndex, window, true)
        return currentWindow.tag as? MediaDescriptionCompat ?: DEFAULT_DESCRIPTION
    }
}