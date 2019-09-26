package com.pvasilev.music.di.modules;

import com.pvasilev.music.presentation.album.details.AlbumDetailsViewModel;
import com.pvasilev.music.presentation.album.details.AlbumDetailsViewModel_AssistedFactory;
import com.pvasilev.music.presentation.player.PlayNowViewModel;
import com.pvasilev.music.presentation.player.PlayNowViewModel_AssistedFactory;
import dagger.Binds;
import dagger.Module;

@Module
public interface ViewModelModule {
    @Binds
    PlayNowViewModel.Factory bindPlayNowViewModelFactory(PlayNowViewModel_AssistedFactory factory);

    @Binds
    AlbumDetailsViewModel.Factory bindAlbumDetailsViewModelFactory(AlbumDetailsViewModel_AssistedFactory factory);
}
