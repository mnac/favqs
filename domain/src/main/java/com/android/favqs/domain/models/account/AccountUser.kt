package com.android.favqs.domain.models.account

import java.io.Serializable

data class AccountUser(
    val login: String,
    val pictureUrl: String?,
    val publicFavoritesCount: Int
) : Serializable