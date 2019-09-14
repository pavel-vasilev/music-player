package com.pvasilev.music.domain

import android.support.v4.media.MediaBrowserCompat.MediaItem
import com.pvasilev.music.data.mappers.Mapper
import com.pvasilev.music.data.models.Album
import com.pvasilev.music.data.repositories.albums.AlbumsDataSource
import javax.inject.Inject

interface GetAlbumsMediaUseCase {
    operator fun invoke(): List<MediaItem>
}

class GetAlbumsMediaUseCaseImpl @Inject constructor(
    private val dataSource: AlbumsDataSource,
    private val mapper: Mapper<Album, MediaItem>
) : GetAlbumsMediaUseCase {
    override fun invoke(): List<MediaItem> {
        return dataSource.getAlbums().map(mapper::map)
    }
}