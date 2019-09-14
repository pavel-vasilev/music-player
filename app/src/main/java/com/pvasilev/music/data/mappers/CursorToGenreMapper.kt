package com.pvasilev.music.data.mappers

import android.database.Cursor
import android.provider.BaseColumns
import android.provider.MediaStore
import com.pvasilev.music.data.models.Genre
import javax.inject.Inject

class CursorToGenreMapper @Inject constructor(): Mapper<Cursor, Genre> {
    override fun map(cursor: Cursor): Genre {
        return Genre(
            cursor.getLong(cursor.getColumnIndex(BaseColumns._ID)),
            cursor.getString(cursor.getColumnIndex(MediaStore.Audio.GenresColumns.NAME))
        )
    }
}