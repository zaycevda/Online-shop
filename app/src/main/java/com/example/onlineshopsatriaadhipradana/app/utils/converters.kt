package com.example.onlineshopsatriaadhipradana.app.utils

import com.example.data.retrofit.model.DetailsResponse
import com.example.data.retrofit.model.FlashSaleModel
import com.example.data.retrofit.model.LatestModel
import com.example.domain.model.Details
import com.example.domain.model.FlashSale
import com.example.domain.model.Latest

fun Details.toDetailsResponse() =
    DetailsResponse(
        name = this.name,
        description = this.description,
        rating = this.rating,
        numberOfReviews = this.numberOfReviews,
        price = this.price,
        colors = this.colors,
        imageUrls = this.imageUrls
    )

fun Latest.toLatestModel() =
    LatestModel(
        category = this.category,
        name = this.name,
        price = this.price,
        imageUrl = this.imageUrl
    )

fun FlashSale.toFlashSaleModel() =
    FlashSaleModel(
        category = this.category,
        name = this.name,
        price = this.price,
        discount = this.discount,
        imageUrl = this.imageUrl
    )