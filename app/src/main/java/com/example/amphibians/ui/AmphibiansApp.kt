package com.example.amphibians.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians.R
import com.example.amphibians.ui.screens.AmphibiaViewModel
import com.example.amphibians.ui.screens.AmphibiansHomeScreen

@Composable
fun AmphibiansApp(modifier: Modifier = Modifier) {
    val viewModel: AmphibiaViewModel = viewModel(factory = AmphibiaViewModel.Factory)
    Scaffold(
        topBar = { AmphibiansTopAppBar() },
        modifier = Modifier.fillMaxSize()
    ) {
        AmphibiansHomeScreen(
            contentPadding = it,
            state = viewModel.amphibiansUiState
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibiansTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(title = { Text(stringResource(R.string.app_name)) })
}