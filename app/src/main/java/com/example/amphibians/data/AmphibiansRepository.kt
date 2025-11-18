package com.example.amphibians.data

import com.example.amphibians.network.Amphibia

interface AmphibiansRepository {
    suspend fun getAmphibians(): List<Amphibia>
}