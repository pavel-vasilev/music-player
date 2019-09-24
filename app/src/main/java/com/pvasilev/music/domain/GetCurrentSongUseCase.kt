package com.pvasilev.music.domain

import android.support.v4.media.MediaMetadataCompat
import com.pvasilev.music.data.mappers.Mapper
import com.pvasilev.music.data.models.Song
import com.pvasilev.music.data.repositories.metadata.MetadataDataSource
import io.reactivex.Observable
import javax.inject.Inject

interface GetCurrentSongUseCase {
    operator fun invoke(): Observable<Song>
}

class GetCurrentSongUseCaseImpl @Inject constructor(
    private val dataSource: MetadataDataSource,
    private val mapper: Mapper<MediaMetadataCompat, Song>
) : GetCurrentSongUseCase {
    override fun invoke(): Observable<Song> {
        return dataSource.getMetadata().map(mapper::map)
    }
}