package com.android.favqs.usecases

import com.android.favqs.domain.repository.AccountRepository

class ConnectUserUseCase(private val accountRepository: AccountRepository) {
    suspend operator fun invoke(email: String, password: String) {
        accountRepository.connectUser(email, password)
    }
}