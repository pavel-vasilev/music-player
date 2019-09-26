package com.pvasilev.music.presentation.album.details

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.pvasilev.music.domain.GetAlbumDetailsUseCase
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class AlbumDetailsViewModel @AssistedInject constructor(
    @Assisted initialState: AlbumDetailsState,
    getAlbumDetails: GetAlbumDetailsUseCase
) : BaseMvRxViewModel<AlbumDetailsState>(initialState, false) {

    init {
        val albumDetails = getAlbumDetails(initialState.albumId)
        setState {
            copy(albumDetails = albumDetails)
        }
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(initialState: AlbumDetailsState): AlbumDetailsViewModel
    }

    companion object : MvRxViewModelFactory<AlbumDetailsViewModel, AlbumDetailsState> {
        override fun create(viewModelContext: ViewModelContext, state: AlbumDetailsState): AlbumDetailsViewModel? {
            val fragment = (viewModelContext as FragmentViewModelContext).fragment<AlbumDetailsFragment>()
            return fragment.viewModelFactory.create(state)
        }
    }
}