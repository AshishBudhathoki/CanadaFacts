package com.demo.data.utils

import android.util.Log

/**
 * Logging class, used in debug mode
 */
object AppLogger {
    /**
     * Indicates if we are in debug mode.
     */
    /**
     * Used to enable or disable logging, and other debug features. Defaults to BuildConfig.DEBUG.
     *
     * @param enabled Debug features (like logging) are enabled if true, disabled if false.
     */
    @Volatile
    private var isDebugEnabled = true

    fun logD(tag: String?, msg: String?) {
        if (isDebugEnabled && tag != null && msg != null) {
            Log.d(tag, msg)
        }
    }

    fun logI(tag: String?, msg: String?) {
        if (isDebugEnabled && tag != null && msg != null) {
            Log.i(tag, msg)
        }
    }

    fun logE(tag: String?, e: String?) {
        if (isDebugEnabled && tag != null && e != null) {
            Log.e(tag, e)
        }
    }
}