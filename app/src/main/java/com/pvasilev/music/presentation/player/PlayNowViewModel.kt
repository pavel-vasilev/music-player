package com.pvasilev.music.presentation.player

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.pvasilev.music.domain.GetCurrentSongUseCase
import com.pvasilev.music.domain.GetPlaybackStateUseCase
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import io.reactivex.android.schedulers.AndroidSchedulers

class PlayNowViewModel @AssistedInject constructor(
    @Assisted initialState: PlayNowState,
    getCurrentSong: GetCurrentSongUseCase,
    getPlaybackState: GetPlaybackStateUseCase
) : BaseMvRxViewModel<PlayNowState>(initialState, false) {

    init {
        getCurrentSong()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                setState {
                    copy(currentSong = it)
                }
            }
            .disposeOnClear()
        getPlaybackState()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                setState {
                    copy(playbackState = it)
                }
            }
            .disposeOnClear()
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(initialState: PlayNowState): PlayNowViewModel
    }

    companion object : MvRxViewModelFactory<PlayNowViewModel, PlayNowState> {
        override fun create(viewModelContext: ViewModelContext, state: PlayNowState): PlayNowViewModel {
            val fragment = (viewModelContext as FragmentViewModelContext).fragment<PlayNowFragment>()
            return fragment.viewModelFactory.create(state)
        }
    }
}