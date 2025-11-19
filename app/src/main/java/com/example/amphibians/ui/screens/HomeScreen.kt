package com.example.amphibians.ui.screens

import android.util.Log.i
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.R
import com.example.amphibians.network.Amphibia
import com.example.amphibians.ui.theme.AmphibiansTheme

@Composable
fun AmphibiansHomeScreen(modifier: Modifier = Modifier) {
    
}

@Composable
fun AmphibiansList(
    amphibians: List<Amphibia>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(10.dp)
    ) {
        items(items = amphibians, key = { amphibia -> amphibia.name }) {
            AmphibiaCard(
                amphibia = it,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .aspectRatio(1.5f)
            )
        }
    }
}

@Composable
fun AmphibiaCard(amphibia: Amphibia, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column(modifier = modifier.background(Color.Green)) {
            Text(
                text = "${amphibia.name} (${amphibia.type})",
                style = MaterialTheme.typography.displayMedium
            )
            AsyncImage(
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(amphibia.imgSrc)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(R.drawable.loading_img),
                error = painterResource(R.drawable.ic_broken_image),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AmphibiansListPrev() {
    val mockData = List(10) {
        Amphibia(
            name = "Frog$it",
            type = "Toad",
            description = "some description",
            imgSrc = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/great-basin-spadefoot.png"
        )
    }
    AmphibiansTheme {
        AmphibiansList(
            mockData,
            Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AmphibiaCardPrev() {
    val mockData = Amphibia(
        name = "Frog",
        type = "Toad",
        description = "some description",
        imgSrc = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/great-basin-spadefoot.png"
    )
    AmphibiansTheme {
        AmphibiaCard(
            amphibia = mockData,
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .aspectRatio(1.5f)
        )
    }
}