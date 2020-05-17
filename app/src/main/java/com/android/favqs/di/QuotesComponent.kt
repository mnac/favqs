package com.android.favqs.di

import com.android.favqs.ui.main.quotes.QuotesFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface QuotesComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): QuotesComponent
    }

    fun inject(quotesFragment: QuotesFragment)
}