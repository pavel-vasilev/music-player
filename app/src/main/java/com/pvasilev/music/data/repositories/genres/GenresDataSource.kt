package com.pvasilev.music.data.repositories.genres

import android.content.ContentResolver
import android.database.Cursor
import android.provider.MediaStore.Audio.Genres.EXTERNAL_CONTENT_URI
import com.pvasilev.music.data.mappers.Mapper
import com.pvasilev.music.data.models.Genre
import javax.inject.Inject

interface GenresDataSource {
    fun getGenres(): List<Genre>
}

class GenresDataSourceImpl @Inject constructor(
    private val contentResolver: ContentResolver,
    private val mapper: Mapper<Cursor, List<Genre>>
) : GenresDataSource {
    override fun getGenres(): List<Genre> {
        val cursor = contentResolver.query(EXTERNAL_CONTENT_URI, null, null, null, null) ?: return emptyList()
        return cursor.use(mapper::map)
    }
}