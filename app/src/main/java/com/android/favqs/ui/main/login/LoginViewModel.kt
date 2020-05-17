package com.android.favqs.ui.main.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.favqs.di.ActivityScope
import com.android.favqs.domain.repository.AccountRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@ActivityScope
class LoginViewModel @Inject constructor(
    private val accountRepository: AccountRepository
) : ViewModel() {

    fun connect() {
        viewModelScope.launch {
            try {
                // val connectionResult1 = accountRepository.connectUser("xxx", "xxx")
            } catch (e: Exception) {
            }
        }
    }
}
