package com.android.favqs.frameworks

import android.content.Context
import android.content.SharedPreferences
import com.android.favqs.data.service.local.PersistedPreferences
import javax.inject.Inject


class LocalPreferences @Inject constructor(context: Context) : PersistedPreferences {

    companion object {
        private const val SETTINGS = "settings"
    }

    private val sharedPreferences: SharedPreferences

    init {
        this.sharedPreferences = context.getSharedPreferences(SETTINGS, Context.MODE_PRIVATE)
    }

    override fun putString(key: String, value: String) {
        sharedPreferences
            .edit()
            .putString(key, value)
            .apply()
    }

    override fun removeString(key: String) {
        sharedPreferences
            .edit()
            .remove(key)
            .apply()
    }

    override fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }
}