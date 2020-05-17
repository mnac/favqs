package com.android.favqs.di

import com.android.favqs.ui.main.login.LoginFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface LoginComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginComponent
    }

    fun inject(loginFragment: LoginFragment)
}