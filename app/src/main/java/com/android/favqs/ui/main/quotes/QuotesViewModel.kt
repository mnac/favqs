package com.android.favqs.ui.main.quotes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.favqs.di.ActivityScope
import com.android.favqs.domain.models.quotes.Quote
import com.android.favqs.domain.repository.AccountRepository
import com.android.favqs.domain.repository.QuotesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@ActivityScope
class QuotesViewModel @Inject constructor(
    private val accountRepository: AccountRepository,
    private val quotesRepository: QuotesRepository
) : ViewModel() {

    val quotes = MutableLiveData<List<Quote>>().apply { value = emptyList() }
    val isError = MutableLiveData<Boolean>().apply { value = false }
    val isEmpty = MutableLiveData<Boolean>().apply { value = false }

    fun loadQuotes() {
        viewModelScope.launch {
            try {
                isEmpty.value = false
                isError.value = false

                val accountUser = accountRepository.getAccountUser()
                quotes.value = quotesRepository.getFavoritesQuotes(accountUser.login)
                if (quotes.value.isNullOrEmpty()) {
                    isEmpty.value = true
                    isError.value = false
                }
            } catch (e: Exception) {
                isEmpty.value = false
                isError.value = true
            }
        }
    }
}
