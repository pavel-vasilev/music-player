package com.pvasilev.music.domain

import android.support.v4.media.MediaBrowserCompat.MediaItem
import com.pvasilev.music.data.mappers.Mapper
import com.pvasilev.music.data.models.Song
import com.pvasilev.music.data.repositories.songs.SongsDataSource
import javax.inject.Inject

interface GetAlbumMediaUseCase {
    operator fun invoke(albumId: Long): List<MediaItem>
}

class GetAlbumMediaUseCaseImpl @Inject constructor(
    private val dataSource: SongsDataSource,
    private val mapper: Mapper<Song, MediaItem>
) : GetAlbumMediaUseCase {
    override fun invoke(albumId: Long): List<MediaItem> {
        return dataSource.getSongsForAlbum(albumId).map(mapper::map)
    }
}

