package com.pvasilev.music.presentation.player

import android.os.Bundle
import android.support.v4.media.session.MediaControllerCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.pvasilev.music.R
import com.squareup.picasso.Picasso
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_play_now.*
import javax.inject.Inject

class PlayNowFragment : BaseMvRxFragment() {
    @Inject
    lateinit var viewModelFactory: PlayNowViewModel.Factory

    private val viewModel: PlayNowViewModel by fragmentViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_play_now, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_next.setOnClickListener {
            val mediaController = MediaControllerCompat.getMediaController(requireActivity())
            mediaController.transportControls.skipToNext()
        }
        btn_previous.setOnClickListener {
            val mediaController = MediaControllerCompat.getMediaController(requireActivity())
            mediaController.transportControls.skipToPrevious()
        }
    }

    override fun invalidate() {
        withState(viewModel) { state ->
            if (state.isPlaying) {
                btn_play_pause.setImageResource(R.drawable.ic_pause)
                btn_play_pause.setOnClickListener {
                    val mediaController = MediaControllerCompat.getMediaController(requireActivity())
                    mediaController.transportControls.pause()
                }
            }
            if (state.isPaused) {
                btn_play_pause.setImageResource(R.drawable.ic_play)
                btn_play_pause.setOnClickListener {
                    val mediaController = MediaControllerCompat.getMediaController(requireActivity())
                    mediaController.transportControls.play()
                }
            }
            Picasso.get()
                .load(state.currentSong.albumArt)
                .into(iv_cover)
        }
    }
}