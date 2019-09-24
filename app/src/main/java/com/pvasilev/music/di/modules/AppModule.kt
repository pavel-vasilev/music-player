package com.pvasilev.music.di.modules

import android.content.ContentResolver
import android.content.Context
import android.support.v4.media.session.MediaControllerCompat
import android.support.v4.media.session.MediaSessionCompat
import com.pvasilev.music.di.scopes.AppScoped
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provideContentResolver(context: Context): ContentResolver = context.contentResolver

    @Provides
    @AppScoped
    fun provideMediaSession(context: Context): MediaSessionCompat {
        return MediaSessionCompat(context, "MediaSession")
    }

    @Provides
    @AppScoped
    fun provideMediaController(context: Context, mediaSession: MediaSessionCompat): MediaControllerCompat {
        return MediaControllerCompat(context, mediaSession)
    }
}