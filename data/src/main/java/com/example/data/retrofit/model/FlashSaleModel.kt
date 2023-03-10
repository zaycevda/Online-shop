package com.example.data.retrofit.model

import com.google.gson.annotations.SerializedName

data class FlashSaleModel(
    val category: String,
    val name: String,
    val price: String,
    val discount: String,
    @SerializedName("image_url")
    val imageUrl: String
)