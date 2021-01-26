package com.demo.data.utils

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPrefsHelper @Inject constructor(private val mSharedPreferences: SharedPreferences) {
    fun put(key: String?, value: String?) {
        mSharedPreferences.edit().putString(key, value).apply()
    }

    fun put(key: String?, value: Int) {
        mSharedPreferences.edit().putInt(key, value).apply()
    }

    fun put(key: String?, value: Float) {
        mSharedPreferences.edit().putFloat(key, value).apply()
    }

    fun put(key: String?, value: Long) {
        mSharedPreferences.edit().putLong(key, value).apply()
    }

    fun put(key: String?, value: Boolean) {
        mSharedPreferences.edit().putBoolean(key, value).apply()
    }

    operator fun get(key: String, defaultValue: String?): String {
        return mSharedPreferences.getString(key, defaultValue).toString()
    }

    operator fun get(key: String?, defaultValue: Int): Int {
        return mSharedPreferences.getInt(key, defaultValue)
    }

    operator fun get(key: String?, defaultValue: Long): Long {
        return mSharedPreferences.getLong(key, defaultValue)
    }

    operator fun get(key: String?, defaultValue: Float): Float {
        return mSharedPreferences.getFloat(key, defaultValue)
    }

    operator fun get(key: String?, defaultValue: Boolean): Boolean {
        return mSharedPreferences.getBoolean(key, defaultValue)
    }

    fun clear() {
        mSharedPreferences.edit().clear().apply()
    }

    companion object {
        const val PREF_NAME = "app_default_pref"
        const val TOOLBAR_TITLE = "toolbar_title"
    }

}