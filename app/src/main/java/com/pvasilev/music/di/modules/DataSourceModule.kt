package com.pvasilev.music.di.modules

import com.pvasilev.music.data.repositories.albums.AlbumsDataSource
import com.pvasilev.music.data.repositories.albums.AlbumsDataSourceImpl
import com.pvasilev.music.data.repositories.genres.GenresDataSource
import com.pvasilev.music.data.repositories.genres.GenresDataSourceImpl
import com.pvasilev.music.data.repositories.songs.SongsDataSource
import com.pvasilev.music.data.repositories.songs.SongsDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface DataSourceModule {
    @Binds
    fun bindAlbumsDataSource(dataSource: AlbumsDataSourceImpl): AlbumsDataSource

    @Binds
    fun bindSongsDataSource(dataSource: SongsDataSourceImpl): SongsDataSource

    @Binds
    fun bindGenresDataSource(dataSource: GenresDataSourceImpl): GenresDataSource
}