package com.android.favqs.domain.models.quotes

import java.io.Serializable

data class Quote(
    val author: String,
    val body: String
) : Serializable