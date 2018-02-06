package com.davepacheco.kodein.services

import android.content.SharedPreferences
import androidx.content.edit


class PersistenceService(private val sharedPreferences: SharedPreferences) {

    fun setValueIntoStore(value: String) {
        sharedPreferences.edit {
            putString("MY_KEY", value)
        }
    }

    fun getValueFromStore(): String = sharedPreferences.getString("MY_KEY", "No value")
}