package com.pvasilev.music.di.modules

import com.pvasilev.music.presentation.album.details.AlbumDetailsFragment
import com.pvasilev.music.presentation.player.PlayNowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {
    @ContributesAndroidInjector
    fun bindPlayNowFragment(): PlayNowFragment

    @ContributesAndroidInjector
    fun bindAlbumDetailsFragment(): AlbumDetailsFragment
}