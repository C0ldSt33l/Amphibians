package com.example.amphibians.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.amphibians.network.Amphibia

@Composable
fun AmphibiansApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { AmphibiansTopAppBar() },
        modifier = Modifier.fillMaxSize()
    ) {
       it
    }
}

@Composable
fun AmphibiansTopAppBar(modifier: Modifier = Modifier) {
    
}