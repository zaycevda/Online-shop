package com.example.data.retrofit.model

import com.google.gson.annotations.SerializedName

data class LatestModel(
    val category: String,
    val name: String,
    val price: String,
    @SerializedName("image_url")
    val imageUrl: String
)