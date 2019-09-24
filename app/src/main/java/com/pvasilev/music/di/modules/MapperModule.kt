package com.pvasilev.music.di.modules

import android.database.Cursor
import android.support.v4.media.MediaBrowserCompat.MediaItem
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaSessionCompat.QueueItem
import com.pvasilev.music.data.mappers.*
import com.pvasilev.music.data.models.Album
import com.pvasilev.music.data.models.Genre
import com.pvasilev.music.data.models.Song
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface MapperModule {
    @Binds
    fun bindAlbumToMediaItemMapper(mapper: AlbumToMediaItemMapper): Mapper<Album, MediaItem>

    @Binds
    fun bindSongToMediaItemMapper(mapper: SongToMediaItemMapper): Mapper<Song, MediaItem>

    @Binds
    fun bindGenreToMediaItemMapper(mapper: GenreToMediaItemMapper): Mapper<Genre, MediaItem>

    @Binds
    fun bindMediaItemToQueueItemMapper(mapper: MediaItemToQueueItemMapper): Mapper<MediaItem, QueueItem>

    @Binds
    fun bindMetadataToSongMapper(mapper: MetadataToSongMapper): Mapper<MediaMetadataCompat, Song>

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun bindCursorToAlbumListMapper(mapper: CursorToAlbumMapper): Mapper<Cursor, List<Album>> {
            return CursorToListMapper(mapper)
        }

        @Provides
        @JvmStatic
        fun bindCursorToSongListMapper(mapper: CursorToSongMapper): Mapper<Cursor, List<Song>> {
            return CursorToListMapper(mapper)
        }

        @Provides
        @JvmStatic
        fun bindCursorToGenreListMapper(mapper: CursorToGenreMapper): Mapper<Cursor, List<Genre>> {
            return CursorToListMapper(mapper)
        }
    }
}