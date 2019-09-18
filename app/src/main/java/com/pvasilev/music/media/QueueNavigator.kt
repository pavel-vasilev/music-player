package com.pvasilev.music.media

import android.support.v4.media.MediaDescriptionCompat
import android.support.v4.media.session.MediaControllerCompat
import android.support.v4.media.session.MediaSessionCompat
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ext.mediasession.TimelineQueueNavigator
import javax.inject.Inject

class QueueNavigator @Inject constructor(
    mediaSession: MediaSessionCompat,
    private val mediaController: MediaControllerCompat
) : TimelineQueueNavigator(mediaSession) {

    override fun getMediaDescription(player: Player, windowIndex: Int): MediaDescriptionCompat {
        return mediaController.queue[windowIndex].description
    }
}