package com.android.favqs.data.source.account.models

import com.android.favqs.domain.models.account.AccountUser
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AccountUserRemoteData(
    val login: String,
    @SerializedName("pic_url") val pictureUrl: String?,
    @SerializedName("public_favorites_count") val publicFavoritesCount: Int
) : Serializable

fun AccountUserRemoteData.toDomain() = AccountUser(
    login = login,
    pictureUrl = pictureUrl,
    publicFavoritesCount = publicFavoritesCount
)