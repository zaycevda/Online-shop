package com.example.data.utils

import com.example.data.retrofit.model.DetailsResponse
import com.example.data.retrofit.model.FlashSaleModel
import com.example.data.retrofit.model.LatestModel
import com.example.data.room.entity.AccountEntity
import com.example.domain.model.Account
import com.example.domain.model.Details
import com.example.domain.model.FlashSale
import com.example.domain.model.Latest

fun toAccountEntity(account: Account, id: Long = 0) =
    AccountEntity(
        id = id,
        email = account.email,
        firstName = account.firstName,
        lastName = account.lastName
    )

fun FlashSaleModel.toFlashSale() =
    FlashSale(
        category = this.category,
        name = this.name,
        price = this.price,
        discount = this.discount,
        imageUrl = this.imageUrl
    )

fun LatestModel.toLatest() =
    Latest(
        category = this.category,
        name = this.name,
        price = this.price,
        imageUrl = this.imageUrl
    )

fun DetailsResponse.toDetails() =
    Details(
        name = this.name,
        description = this.description,
        rating = this.rating,
        numberOfReviews = this.numberOfReviews,
        price = this.price,
        colors = this.colors,
        imageUrls = this.imageUrls
    )