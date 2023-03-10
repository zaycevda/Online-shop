package com.example.domain.model

data class Details(
    val name: String,
    val description: String,
    val rating: String,
    val numberOfReviews: String,
    val price: Int,
    val colors: List<String>,
    val imageUrls: List<String>
)