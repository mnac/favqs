package com.android.favqs.ui.main.landing

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.favqs.di.ActivityScope
import com.android.favqs.domain.repository.AccountRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@ActivityScope
class LandingViewModel @Inject constructor(
    val accountRepository: AccountRepository
) : ViewModel() {

    enum class AuthenticationState {
        PENDING,
        AUTHENTICATED,
        UNAUTHENTICATED
    }

    val authenticationState = MutableLiveData<AuthenticationState>()
    val usernameState = MutableLiveData<String>()

    init {
        authenticationState.value = AuthenticationState.PENDING
    }

    fun onSubscribe() {
        viewModelScope.launch {
            try {
                delay(2500)
                val accountUser = accountRepository.getAccountUser()
                usernameState.value = accountUser.login
                authenticationState.value = AuthenticationState.AUTHENTICATED
            } catch (e: Exception) {
                authenticationState.value = AuthenticationState.UNAUTHENTICATED
            }
        }

    }
}
