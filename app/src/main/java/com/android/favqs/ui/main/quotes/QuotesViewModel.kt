package com.android.favqs.ui.main.quotes

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.favqs.di.ActivityScope
import com.android.favqs.domain.repository.AccountRepository
import com.android.favqs.domain.repository.QuotesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@ActivityScope
class QuotesViewModel @Inject constructor(
    private val accountRepository: AccountRepository,
    private val quotesRepository: QuotesRepository
) : ViewModel() {
    
    fun loadQuotes() {
        viewModelScope.launch {
            try {
                val accountUser = accountRepository.getAccountUser()
                val quotes = quotesRepository.getFavoritesQuotes(accountUser.login)
            } catch (e: Exception) {

            }
        }
    }
}
