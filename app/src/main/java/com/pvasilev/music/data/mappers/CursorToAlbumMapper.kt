package com.pvasilev.music.data.mappers

import android.database.Cursor
import android.provider.BaseColumns
import android.provider.MediaStore
import com.pvasilev.music.data.models.Album
import javax.inject.Inject

class CursorToAlbumMapper @Inject constructor(): Mapper<Cursor, Album> {
    override fun map(cursor: Cursor): Album {
        return Album(
            cursor.getLong(cursor.getColumnIndex(BaseColumns._ID)),
            cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AlbumColumns.ALBUM)),
            cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AlbumColumns.ARTIST))
        )
    }
}