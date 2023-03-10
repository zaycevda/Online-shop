package com.example.data.retrofit.model

import com.google.gson.annotations.SerializedName

data class DetailsResponse(
    val name: String,
    val description: String,
    val rating: String,
    @SerializedName("number_of_reviews")
    val numberOfReviews: String,
    val price: Int,
    val colors: List<String>,
    @SerializedName("image_urls")
    val imageUrls: List<String>
)