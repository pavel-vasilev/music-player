package com.pvasilev.music.di.modules

import android.content.Context
import android.support.v4.media.session.MediaSessionCompat
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.ads.AdsMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.pvasilev.music.di.scopes.ServiceScoped
import com.pvasilev.music.media.PlaybackPreparer
import com.pvasilev.music.media.QueueNavigator
import dagger.Module
import dagger.Provides

@Module
class MediaModule {
    @Provides
    @ServiceScoped
    fun provideMediaSession(context: Context): MediaSessionCompat {
        return MediaSessionCompat(context, "MediaSession")
    }

    @Provides
    @ServiceScoped
    fun provideMediaSessionConnector(
        mediaSession: MediaSessionCompat,
        player: ExoPlayer,
        queueNavigator: MediaSessionConnector.QueueNavigator,
        playbackPreparer: MediaSessionConnector.PlaybackPreparer
    ): MediaSessionConnector {
        return MediaSessionConnector(mediaSession).apply {
            setPlaybackPreparer(playbackPreparer)
            setQueueNavigator(queueNavigator)
            setPlayer(player)
        }
    }

    @Provides
    @ServiceScoped
    fun provideQueueNavigator(queueNavigator: QueueNavigator): MediaSessionConnector.QueueNavigator {
        return queueNavigator
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

    @Provides
    @ServiceScoped
    fun providePlaybackPreparer(playbackPreparer: PlaybackPreparer): MediaSessionConnector.PlaybackPreparer {
        return playbackPreparer
    }
}