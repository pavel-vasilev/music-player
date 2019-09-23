package com.pvasilev.music.data

import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaControllerCompat
import android.support.v4.media.session.PlaybackStateCompat
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe

class MediaControllerChangeEventObservable(private val mediaController: MediaControllerCompat) : ObservableOnSubscribe<MediaControllerChangeEvent> {
    override fun subscribe(emitter: ObservableEmitter<MediaControllerChangeEvent>) {
        val callback = object : MediaControllerCompat.Callback() {
            override fun onMetadataChanged(metadata: MediaMetadataCompat) {
                emitter.onNext(MediaControllerChangeEvent.MetadataChange(metadata))
            }

            override fun onPlaybackStateChanged(state: PlaybackStateCompat) {
                emitter.onNext(MediaControllerChangeEvent.PlaybackStateChange(state))
            }
        }
        mediaController.registerCallback(callback)
        emitter.setCancellable {
            mediaController.unregisterCallback(callback)
        }
    }
}

sealed class MediaControllerChangeEvent {
    class MetadataChange(val metadata: MediaMetadataCompat) : MediaControllerChangeEvent()
    class PlaybackStateChange(val playbackState: PlaybackStateCompat) : MediaControllerChangeEvent()
}

fun MediaControllerCompat.changeEvents(): Observable<MediaControllerChangeEvent> {
    return Observable.create(MediaControllerChangeEventObservable(this))
}