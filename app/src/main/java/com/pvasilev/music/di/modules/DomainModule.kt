package com.pvasilev.music.di.modules

import com.pvasilev.music.domain.*
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {
    @Binds
    fun bindGetAlbumMediaUseCase(useCase: GetAlbumMediaUseCaseImpl): GetAlbumMediaUseCase

    @Binds
    fun bindGetAlbumsMediaUseCase(useCase: GetAlbumsMediaUseCaseImpl): GetAlbumsMediaUseCase

    @Binds
    fun bindGetGenreMediaUseCase(useCase: GetGenreMediaUseCaseImpl): GetGenreMediaUseCase

    @Binds
    fun bindGetGenresMediaUseCase(useCase: GetGenresMediaUseCaseImpl): GetGenresMediaUseCase

    @Binds
    fun bindGetRootMediaUseCase(useCase: GetRootMediaUseCaseImpl): GetRootMediaUseCase

    @Binds
    fun bindGetMediaUseCase(useCase: GetMediaUseCaseImpl): GetMediaUseCase

    @Binds
    fun bindGetQueueUseCase(useCase: GetQueueUseCaseImpl): GetQueueUseCase

    @Binds
    fun bindGetCurrentSongUseCase(useCase: GetCurrentSongUseCaseImpl): GetCurrentSongUseCase

    @Binds
    fun bindGetPlaybackStateUseCase(useCase: GetPlaybackStateUseCaseImpl): GetPlaybackStateUseCase
}