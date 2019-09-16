package com.pvasilev.music.di.modules

import com.pvasilev.music.di.scopes.ServiceScoped
import com.pvasilev.music.media.MusicService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ServiceBuilderModule {
    @ServiceScoped
    @ContributesAndroidInjector(modules = [MediaModule::class])
    fun bindMusicService(): MusicService
}