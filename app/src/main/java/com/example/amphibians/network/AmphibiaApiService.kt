package com.example.amphibians.network

import retrofit2.http.GET

interface AmphibiaApiService {
    @GET("Amphibians")
    suspend fun getAmphibiansData(): List<Amphibia>
}