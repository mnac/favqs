package com.android.favqs.data.service.local

interface PersistedPreferences {
    fun putString(key: String, value: String)
    fun removeString(key: String)
    fun getString(key: String): String?
}