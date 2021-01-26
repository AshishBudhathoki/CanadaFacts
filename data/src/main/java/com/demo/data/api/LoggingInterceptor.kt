package com.demo.data.api

import okhttp3.logging.HttpLoggingInterceptor

/**
 * Interceptor for hhtp request url and response
 */

object LoggingInterceptor {

    fun create(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

}