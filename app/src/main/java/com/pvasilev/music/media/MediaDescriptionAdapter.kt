package com.pvasilev.music.media

import android.app.PendingIntent
import android.graphics.Bitmap
import android.support.v4.media.session.MediaControllerCompat
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.PlayerNotificationManager
import javax.inject.Inject

class MediaDescriptionAdapter @Inject constructor(private val mediaController: MediaControllerCompat) : PlayerNotificationManager.MediaDescriptionAdapter {
    override fun createCurrentContentIntent(player: Player): PendingIntent? {
        return null
    }

    override fun getCurrentContentTitle(player: Player): String? {
        val index = player.currentWindowIndex
        val description = mediaController.queue[index].description
        return description.title.toString()
    }

    override fun getCurrentContentText(player: Player): String? {
        val index = player.currentWindowIndex
        val description = mediaController.queue[index].description
        return description.subtitle.toString()
    }

    override fun getCurrentLargeIcon(player: Player, callback: PlayerNotificationManager.BitmapCallback): Bitmap? {
        return null
    }
}