package com.pvasilev.music.data.repositories.albums

import android.content.ContentResolver
import android.database.Cursor
import android.provider.MediaStore.Audio.AlbumColumns.ALBUM_ID
import android.provider.MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI
import com.pvasilev.music.data.mappers.Mapper
import com.pvasilev.music.data.models.Album
import javax.inject.Inject

interface AlbumsDataSource {
    fun getAlbums(): List<Album>

    fun getAlbum(albumId: Long): Album?
}

class AlbumsDataSourceImpl @Inject constructor(
    private val contentResolver: ContentResolver,
    private val mapper: Mapper<Cursor, List<Album>>
) : AlbumsDataSource {
    override fun getAlbums(): List<Album> {
        val cursor = contentResolver.query(EXTERNAL_CONTENT_URI, null, null, null, null) ?: return emptyList()
        return cursor.use(mapper::map)
    }

    override fun getAlbum(albumId: Long): Album? {
        val selection = "$ALBUM_ID = ?"
        val selectionArgs = arrayOf(albumId.toString())
        val cursor = contentResolver.query(EXTERNAL_CONTENT_URI, null, selection, selectionArgs, null) ?: return null
        return cursor.use(mapper::map).firstOrNull()
    }
}