package com.android.favqs.di

import android.content.Context
import com.android.favqs.data.service.local.PersistedPreferences
import com.android.favqs.frameworks.LocalPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistedPreferencesModule {
    @Provides
    @Singleton
    fun persistedPreferences(context: Context): PersistedPreferences {
        return LocalPreferences(context = context)
    }
}