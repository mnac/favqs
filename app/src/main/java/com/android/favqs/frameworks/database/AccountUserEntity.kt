package com.android.favqs.frameworks.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.favqs.domain.models.account.AccountUser

@Entity
data class AccountUserEntity(
    @PrimaryKey val login: String,
    val pictureUrl: String?,
    val publicFavoritesCount: Int
) {
    companion object {
        fun fromDomain(user: AccountUser) =
            AccountUserEntity(
                login = user.login,
                pictureUrl = user.pictureUrl,
                publicFavoritesCount = user.publicFavoritesCount
            )
    }
}

fun AccountUserEntity.toDomain() = AccountUser(
    login = login,
    pictureUrl = pictureUrl,
    publicFavoritesCount = publicFavoritesCount
)