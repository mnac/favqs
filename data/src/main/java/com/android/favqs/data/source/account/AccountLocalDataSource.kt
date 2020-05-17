package com.android.favqs.data.source.account

import com.android.favqs.data.exception.LocalAccountUserNotAvailable
import com.android.favqs.data.service.local.PersistedDatabase
import com.android.favqs.data.service.local.PersistedPreferences
import com.android.favqs.domain.models.account.AccountToken
import com.android.favqs.domain.models.account.AccountUser
import javax.inject.Inject

class AccountLocalDataSource @Inject constructor(
    private val persistedPreferences: PersistedPreferences,
    private val persistedDatabase: PersistedDatabase
) : AccountDataSource.Local {

    companion object {
        const val ACCOUNT_SESSION_TOKEN = "token_session"
        const val ACCOUNT_SESSION_LOGIN = "login_session"
    }

    override suspend fun saveAccountToken(accountSessionToken: AccountToken) {
        accountSessionToken.token?.let {
            persistedPreferences.putString(ACCOUNT_SESSION_TOKEN, it)
        }
        accountSessionToken.login.let {
            persistedPreferences.putString(ACCOUNT_SESSION_LOGIN, it)
        }
    }

    override suspend fun getAccountToken(): AccountToken {
        val token = persistedPreferences.getString(ACCOUNT_SESSION_TOKEN)
        val login = persistedPreferences.getString(ACCOUNT_SESSION_LOGIN)
        return AccountToken(token = token, login = login ?: "")
    }

    override suspend fun saveAccountUser(user: AccountUser) {
        persistedDatabase.saveAccountUser(user)
    }

    override suspend fun getAccountUser(login: String): AccountUser {
        return persistedDatabase.getAccountUser(login) ?: throw LocalAccountUserNotAvailable()
    }
}