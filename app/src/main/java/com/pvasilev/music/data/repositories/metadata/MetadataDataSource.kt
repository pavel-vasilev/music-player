package com.pvasilev.music.data.repositories.metadata

import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaControllerCompat
import com.pvasilev.music.data.MediaControllerChangeEvent
import com.pvasilev.music.data.changeEvents
import io.reactivex.Observable
import javax.inject.Inject

interface MetadataDataSource {
    fun getMetadata(): Observable<MediaMetadataCompat>
}

class MetadataDataSourceImpl @Inject constructor(private val mediaController: MediaControllerCompat) : MetadataDataSource {
    override fun getMetadata(): Observable<MediaMetadataCompat> {
        return mediaController.changeEvents()
            .filter { it is MediaControllerChangeEvent.MetadataChange }
            .cast(MediaControllerChangeEvent.MetadataChange::class.java)
            .map { it.metadata }
    }
}