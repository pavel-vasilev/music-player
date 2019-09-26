package com.pvasilev.music.presentation.album.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.pvasilev.music.R
import com.pvasilev.music.presentation.adapters.SongsAdapter
import com.squareup.picasso.Picasso
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_album_details.*
import javax.inject.Inject

class AlbumDetailsFragment : BaseMvRxFragment() {
    @Inject
    lateinit var viewModelFactory: AlbumDetailsViewModel.Factory

    private val viewModel: AlbumDetailsViewModel by fragmentViewModel()

    private val adapter: SongsAdapter = SongsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_album_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    override fun invalidate() {
        withState(viewModel) { state ->
            if (state.albumDetails != null) {
                val (album, songs) = state.albumDetails
                Picasso.get().load(album.art).into(iv_cover)
                tv_album.text = album.name
                adapter.submitList(songs)
            }
        }
    }
}