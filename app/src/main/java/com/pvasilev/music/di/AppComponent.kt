package com.pvasilev.music.di

import android.content.Context
import com.pvasilev.music.App
import com.pvasilev.music.di.modules.*
import com.pvasilev.music.di.scopes.AppScoped
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        DataSourceModule::class,
        MapperModule::class,
        DomainModule::class,
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        ActivityBuilderModule::class,
        ServiceBuilderModule::class,
        AppModule::class
    ]
)
@AppScoped
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}