package com.android.favqs

import android.app.Application
import com.android.favqs.di.ContextModule
import com.android.favqs.di.DaggerApplicationGraph

class FavQsApp : Application() {
    val appComponent = DaggerApplicationGraph
        .builder()
        .contextModule(ContextModule(this))
        .build()
}