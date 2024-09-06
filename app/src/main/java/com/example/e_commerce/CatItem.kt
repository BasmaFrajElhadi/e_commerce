package com.example.e_commerce


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatItem(
    @SerialName("_id")
    val id: String,
    @SerialName("mimetype")
    val mimetype: String,
    @SerialName("size")
    val size: Int,
    @SerialName("tags")
    val tags: List<String>
){
    fun imageUrl(): String = "https://cataas.com/cat/$id"
}
