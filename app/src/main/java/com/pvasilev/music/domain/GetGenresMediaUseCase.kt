package com.pvasilev.music.domain

import android.support.v4.media.MediaBrowserCompat.MediaItem
import com.pvasilev.music.data.mappers.Mapper
import com.pvasilev.music.data.models.Genre
import com.pvasilev.music.data.repositories.genres.GenresDataSource

interface GetGenresMediaUseCase {
    operator fun invoke(): List<MediaItem>
}

class GetGenresMediaUseCaseImpl(
    private val dataSource: GenresDataSource,
    private val mapper: Mapper<Genre, MediaItem>
) : GetGenresMediaUseCase {
    override fun invoke(): List<MediaItem> {
        return dataSource.getGenres().map(mapper::map)
    }
}