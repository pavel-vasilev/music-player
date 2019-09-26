package com.pvasilev.music.data.mappers

import android.database.Cursor
import android.provider.BaseColumns
import android.provider.MediaStore
import com.pvasilev.music.data.models.Song
import javax.inject.Inject

class CursorToSongMapper @Inject constructor(): Mapper<Cursor, Song> {
    override fun map(cursor: Cursor): Song {
        return Song(
            cursor.getLong(cursor.getColumnIndex(BaseColumns._ID)),
            cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.TITLE)),
            cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DURATION)),
            cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ALBUM_ID))
        )
    }
}