package com.example.amphibians.data

import com.example.amphibians.network.Amphibia
import com.example.amphibians.network.AmphibiaApiService

class NetworkAmphibiansRepository(private val amphibiaApiServer: AmphibiaApiService): AmphibiansRepository {
    override suspend fun getAmphibians(): List<Amphibia> = amphibiaApiServer.getAmphibiansData()
}