package com.pvasilev.music.data.repositories.songs

import android.content.ContentResolver
import android.database.Cursor
import android.provider.MediaStore.Audio.AudioColumns.ALBUM_ID
import android.provider.MediaStore.Audio.Genres.Members.getContentUri
import android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
import com.pvasilev.music.data.mappers.Mapper
import com.pvasilev.music.data.models.Song

interface SongsDataSource {
    fun getSongs(): List<Song>

    fun getSongsForGenre(genreId: Long): List<Song>

    fun getSongsForAlbum(albumId: Long): List<Song>
}

class SongsDataSourceImpl constructor(
    private val contentResolver: ContentResolver,
    private val mapper: Mapper<Cursor, List<Song>>
) : SongsDataSource {
    override fun getSongs(): List<Song> {
        val cursor = contentResolver.query(EXTERNAL_CONTENT_URI, null, null, null, null) ?: return emptyList()
        return cursor.use(mapper::map)
    }

    override fun getSongsForGenre(genreId: Long): List<Song> {
        val cursor = contentResolver.query(getContentUri("external", genreId), null, null, null, null)
        return cursor.use(mapper::map)
    }

    override fun getSongsForAlbum(albumId: Long): List<Song> {
        val selection = "$ALBUM_ID = ?"
        val selectionArgs = arrayOf(albumId.toString())
        val cursor = contentResolver.query(EXTERNAL_CONTENT_URI, null, selection, selectionArgs, null) ?: return emptyList()
        return cursor.use(mapper::map)
    }
}