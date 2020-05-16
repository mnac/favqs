package com.android.favqs.di

import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        ContextModule::class,
        PersistedPreferencesModule::class,
        NetworkServiceModule::class,
        ServiceRemoteModule::class,
        DataSourceLocalModule::class,
        DataSourceRemoteModule::class
    ]
)
interface ApplicationGraph {

}