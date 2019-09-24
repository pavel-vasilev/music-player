package com.pvasilev.music.di.modules;

import com.pvasilev.music.presentation.player.PlayNowViewModel;
import com.pvasilev.music.presentation.player.PlayNowViewModel_AssistedFactory;
import dagger.Binds;
import dagger.Module;

@Module
public interface ViewModelModule {
    @Binds
    PlayNowViewModel.Factory bindPlayNowViewModelFactory(PlayNowViewModel_AssistedFactory factory);
}
