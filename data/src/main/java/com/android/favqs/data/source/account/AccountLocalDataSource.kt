package com.android.favqs.data.source.account

import com.android.favqs.data.service.local.PersistedPreferences
import com.android.favqs.domain.models.account.AccountToken
import javax.inject.Inject

class AccountLocalDataSource @Inject constructor(
    private val persistedPreferences: PersistedPreferences
) : AccountDataSource.Local {

    companion object {
        const val ACCOUNT_SESSION_TOKEN = "token_session"
    }

    override suspend fun saveAccountToken(accountSessionToken: AccountToken) {
        accountSessionToken.token?.let {
            persistedPreferences.putString(ACCOUNT_SESSION_TOKEN, it)
        }
    }

    override suspend fun getAccountToken(): AccountToken {
        val token = persistedPreferences.getString(ACCOUNT_SESSION_TOKEN)
        return AccountToken(token)
    }
}