package com.example.e_commerce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.e_commerce.ui.theme.E_commerceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            E_commerceTheme {
                Column{
                    CatListView()
                }
            }
        }
    }
}
@Composable
fun CatListView(viewModel: MainViewModel = viewModel()) {
    val catItems = viewModel.catitem

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(catItems.size) { index ->
                CatCard(catItem = catItems[index])
            }
        }
    }
}

@Composable
fun CatCard(catItem: CatItem) {
    val painter = rememberImagePainter(catItem.imageUrl())
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(Color.Transparent),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .background(Color.Transparent)
        ) {
            Image(
                painter = painter,
                contentDescription = "Cat",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
                    .background(Color.Black)
                    .padding(8.dp)
            ) {
                Text(text = "ID: ${catItem.id}", color = Color.White)
                Text(text = "Size: ${catItem.size}", color = Color.White)
                Text(text = "Tags: ${catItem.tags.joinToString(", ")}", color = Color.White)
            }
        }
    }
}
