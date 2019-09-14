package com.pvasilev.music.di.modules

import android.content.ContentResolver
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provideContentResolver(context: Context): ContentResolver = context.contentResolver
}