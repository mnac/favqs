package com.android.favqs.di

import com.android.favqs.ui.main.landing.LandingFragment
import com.android.favqs.ui.main.login.LoginFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface LandingComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): LandingComponent
    }

    fun inject(landingFragment: LandingFragment)
}