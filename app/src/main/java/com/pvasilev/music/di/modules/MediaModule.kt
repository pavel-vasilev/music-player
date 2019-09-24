package com.pvasilev.music.di.modules

import android.content.Context
import android.support.v4.media.session.MediaControllerCompat
import android.support.v4.media.session.MediaSessionCompat
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.ads.AdsMediaSource
import com.google.android.exoplayer2.ui.PlayerNotificationManager
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.pvasilev.music.R
import com.pvasilev.music.di.scopes.ServiceScoped
import com.pvasilev.music.media.MediaDescriptionAdapter
import com.pvasilev.music.media.PlaybackPreparer
import com.pvasilev.music.media.QueueNavigator
import dagger.Module
import dagger.Provides

@Module
class MediaModule {
    @Provides
    @ServiceScoped
    fun provideMediaSessionConnector(
        mediaSession: MediaSessionCompat,
        queueNavigator: MediaSessionConnector.QueueNavigator,
        playbackPreparer: MediaSessionConnector.PlaybackPreparer
    ): MediaSessionConnector {
        return MediaSessionConnector(mediaSession).apply {
            setPlaybackPreparer(playbackPreparer)
            setQueueNavigator(queueNavigator)
        }
    }

    @Provides
    @ServiceScoped
    fun providePlaybackPreparer(playbackPreparer: PlaybackPreparer): MediaSessionConnector.PlaybackPreparer {
        return playbackPreparer
    }

    @Provides
    @ServiceScoped
    fun provideQueueNavigator(queueNavigator: QueueNavigator): MediaSessionConnector.QueueNavigator {
        return queueNavigator
    }

    @Provides
    @ServiceScoped
    fun providePlayerNotificationManager(
        context: Context,
        adapter: PlayerNotificationManager.MediaDescriptionAdapter
    ): PlayerNotificationManager {
        return PlayerNotificationManager.createWithNotificationChannel(
            context,
            context.getString(R.string.playback_channel_id),
            R.string.playback_channel_name,
            R.string.playback_channel_description,
            1,
            adapter
        )
    }

    @Provides
    @ServiceScoped
    fun provideMediaDescriptionAdapter(adapter: MediaDescriptionAdapter): PlayerNotificationManager.MediaDescriptionAdapter {
        return adapter
    }

    @Provides
    @ServiceScoped
    fun provideExoPlayer(context: Context): ExoPlayer {
        return ExoPlayerFactory.newSimpleInstance(context)
    }

    @Provides
    @ServiceScoped
    fun provideDataSourceFactory(context: Context): DataSource.Factory {
        return DefaultDataSourceFactory(context, Util.getUserAgent(context, context.applicationInfo.name))
    }

    @Provides
    @ServiceScoped
    fun provideMediaSourceFactory(dataSourceFactory: DataSource.Factory): AdsMediaSource.MediaSourceFactory {
        return ProgressiveMediaSource.Factory(dataSourceFactory)
    }
}