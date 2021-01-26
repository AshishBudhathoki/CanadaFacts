package com.demo.data.api

import com.demo.data.models.response.CanadaInfoResponse
import retrofit2.http.GET

/**
 * Retrofit Api service to fetch data from web
 */
interface ApiService {
    @GET("facts")
    suspend fun getCanadaInfoFromApi(): CanadaInfoResponse
}