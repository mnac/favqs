package com.android.favqs.data.source.account

import com.android.favqs.data.service.remote.account.AccountRemoteService
import com.android.favqs.data.source.account.models.params.AccountLoginParamsData
import com.android.favqs.data.source.account.models.params.AccountLoginUserParamsData
import com.android.favqs.data.source.account.models.toDomain
import com.android.favqs.domain.models.account.AccountToken
import javax.inject.Inject

class AccountRemoteDataSource @Inject constructor(
    private val accountRemoteService: AccountRemoteService
) : AccountDataSource.Remote {

    override suspend fun loginAccount(email: String, password: String): AccountToken {
        val params = AccountLoginParamsData(
            user = AccountLoginUserParamsData(
                login = email,
                password = password
            )
        )
        return accountRemoteService.loginUser(params = params).toDomain()
    }
}