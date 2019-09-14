package com.pvasilev.music.media

import android.os.Bundle
import android.support.v4.media.MediaBrowserCompat
import androidx.media.MediaBrowserServiceCompat
import com.pvasilev.music.domain.GetMediaUseCase
import com.pvasilev.music.domain.GetMediaUseCase.Companion.ROOT_MEDIA_ID
import dagger.android.AndroidInjection
import javax.inject.Inject

class MusicService : MediaBrowserServiceCompat() {
    @Inject
    lateinit var getMedia: GetMediaUseCase

    override fun onCreate() {
        AndroidInjection.inject(this)
        super.onCreate()
    }

    override fun onGetRoot(clientPackageName: String, clientUid: Int, rootHints: Bundle?): BrowserRoot? {
        return BrowserRoot(ROOT_MEDIA_ID, Bundle.EMPTY)
    }

    override fun onLoadChildren(parentId: String, result: Result<List<MediaBrowserCompat.MediaItem>>) {
        val items = getMedia(parentId)
        result.sendResult(items)
    }
}