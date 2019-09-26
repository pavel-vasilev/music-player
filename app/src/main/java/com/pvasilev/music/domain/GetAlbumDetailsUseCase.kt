package com.pvasilev.music.domain

import com.pvasilev.music.data.models.AlbumDetails
import com.pvasilev.music.data.repositories.albums.AlbumsDataSource
import com.pvasilev.music.data.repositories.songs.SongsDataSource
import javax.inject.Inject

interface GetAlbumDetailsUseCase {
    operator fun invoke(albumId: Long): AlbumDetails?
}

class GetAlbumDetailsUseCaseImpl @Inject constructor(
    private val albumsDataSource: AlbumsDataSource,
    private val songsDataSource: SongsDataSource
) : GetAlbumDetailsUseCase {
    override fun invoke(albumId: Long): AlbumDetails? {
        val album = albumsDataSource.getAlbum(albumId) ?: return null
        val songs = songsDataSource.getSongsForAlbum(albumId)
        return AlbumDetails(album, songs)
    }
}