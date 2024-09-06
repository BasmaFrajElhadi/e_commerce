package com.example.e_commerce

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.client.statement.*

class MainViewModel : ViewModel() {
    val client = Provider.client
    var catitem by mutableStateOf(emptyList<CatItem>())
        private set
    init {
        viewModelScope.launch {

            catitem = client.get("https://cataas.com/api/cats?tags=cute").body<List<CatItem>>()
        }

    }
}

