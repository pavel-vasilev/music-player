package com.pvasilev.music.di.modules

import com.pvasilev.music.media.MusicService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ServiceBuilderModule {
    @ContributesAndroidInjector
    fun bindMusicService(): MusicService
}