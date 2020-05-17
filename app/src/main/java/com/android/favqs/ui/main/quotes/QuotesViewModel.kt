package com.android.favqs.ui.main.quotes

import androidx.lifecycle.ViewModel
import com.android.favqs.di.ActivityScope
import com.android.favqs.domain.repository.AccountRepository
import com.android.favqs.domain.repository.QuotesRepository
import javax.inject.Inject

@ActivityScope
class QuotesViewModel @Inject constructor(
    private val accountRepository: AccountRepository,
    private val quotesRepository: QuotesRepository
) : ViewModel() {

}
