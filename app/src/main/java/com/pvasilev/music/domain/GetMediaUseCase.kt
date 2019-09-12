package com.pvasilev.music.domain

import android.support.v4.media.MediaBrowserCompat.MediaItem
import com.pvasilev.music.domain.GetMediaUseCase.Companion.ALBUMS_MEDIA_ID
import com.pvasilev.music.domain.GetMediaUseCase.Companion.ALBUM_MEDIA_ID
import com.pvasilev.music.domain.GetMediaUseCase.Companion.GENRES_MEDIA_ID
import com.pvasilev.music.domain.GetMediaUseCase.Companion.GENRE_MEDIA_ID
import com.pvasilev.music.domain.GetMediaUseCase.Companion.ROOT_MEDIA_ID

interface GetMediaUseCase {
    companion object {
        const val ROOT_MEDIA_ID = "/"
        const val GENRES_MEDIA_ID = "/genres"
        const val ALBUMS_MEDIA_ID = "/albums"
        const val GENRE_MEDIA_ID = """/genres/\d+"""
        const val ALBUM_MEDIA_ID = """/albums/\d+"""
    }

    operator fun invoke(parentId: String): List<MediaItem>
}

class GetMediaUseCaseImpl(
    private val getRootMedia: GetRootMediaUseCase,
    private val getGenresMedia: GetGenresMediaUseCase,
    private val getAlbumsMedia: GetAlbumsMediaUseCase,
    private val getGenreMedia: GetGenreMediaUseCase,
    private val getAlbumMedia: GetAlbumMediaUseCase
) : GetMediaUseCase {
    override fun invoke(parentId: String): List<MediaItem> {
        return when {
            parentId == ROOT_MEDIA_ID -> getRootMedia()
            parentId == GENRES_MEDIA_ID -> getGenresMedia()
            parentId == ALBUMS_MEDIA_ID -> getAlbumsMedia()
            GENRE_MEDIA_ID.toRegex().matches(parentId) -> getGenreMedia(parentId.substringAfterLast("/").toLong())
            ALBUM_MEDIA_ID.toRegex().matches(parentId) -> getAlbumMedia(parentId.substringAfterLast("/").toLong())
            else -> emptyList()
        }
    }
}