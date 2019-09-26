package com.pvasilev.music.presentation.album.details

import com.airbnb.mvrx.MvRxState
import com.pvasilev.music.data.models.AlbumDetails

data class AlbumDetailsState(
    val albumId: Long,
    val albumDetails: AlbumDetails?
) : MvRxState