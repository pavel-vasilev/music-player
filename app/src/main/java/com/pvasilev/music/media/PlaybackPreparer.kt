package com.pvasilev.music.media

import android.net.Uri
import android.os.Bundle
import android.os.ResultReceiver
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import com.google.android.exoplayer2.ControlDispatcher
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector
import com.google.android.exoplayer2.source.ConcatenatingMediaSource
import com.google.android.exoplayer2.source.ads.AdsMediaSource
import com.pvasilev.music.domain.GetQueueUseCase
import javax.inject.Inject

class PlaybackPreparer @Inject constructor(
    private val player: ExoPlayer,
    private val getQueue: GetQueueUseCase,
    private val mediaSession: MediaSessionCompat,
    private val mediaSourceFactory: AdsMediaSource.MediaSourceFactory
) : MediaSessionConnector.PlaybackPreparer {
    override fun getSupportedPrepareActions(): Long = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID

    override fun onCommand(
        player: Player?,
        controlDispatcher: ControlDispatcher?,
        command: String?,
        extras: Bundle?,
        cb: ResultReceiver?
    ): Boolean = false

    override fun onPrepareFromSearch(query: String?, playWhenReady: Boolean, extras: Bundle?) {
    }

    override fun onPrepareFromUri(uri: Uri?, playWhenReady: Boolean, extras: Bundle?) {
    }

    override fun onPrepareFromMediaId(mediaId: String, playWhenReady: Boolean, extras: Bundle?) {
        val mediaSource = ConcatenatingMediaSource()
        val queue = getQueue(mediaId)
        mediaSession.setQueue(queue)
        val mediaSources = queue.map { mediaSourceFactory.createMediaSource(it.description.mediaUri) }
        mediaSource.addMediaSources(mediaSources)
        player.prepare(mediaSource)
        player.playWhenReady = playWhenReady
    }

    override fun onPrepare(playWhenReady: Boolean) {
        player.playWhenReady = playWhenReady
    }
}