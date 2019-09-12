package com.pvasilev.music.domain

import android.support.v4.media.MediaBrowserCompat.MediaItem
import com.pvasilev.music.data.mappers.Mapper
import com.pvasilev.music.data.models.Song
import com.pvasilev.music.data.repositories.songs.SongsDataSource

interface GetGenreMediaUseCase {
    operator fun invoke(genreId: Long): List<MediaItem>
}

class GetGenreMediaUseCaseImpl(
    private val dataSource: SongsDataSource,
    private val mapper: Mapper<Song, MediaItem>
) : GetGenreMediaUseCase {
    override fun invoke(genreId: Long): List<MediaItem> {
        return dataSource.getSongsForGenre(genreId).map(mapper::map)
    }
}