package com.android.favqs.ui.main.landing

import androidx.lifecycle.ViewModel
import com.android.favqs.di.ActivityScope
import com.android.favqs.domain.repository.AccountRepository
import javax.inject.Inject

@ActivityScope
class LandingViewModel @Inject constructor(
    val accountRepository: AccountRepository
) : ViewModel() {

}
