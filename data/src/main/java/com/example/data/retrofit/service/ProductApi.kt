package com.example.data.retrofit.service

import com.example.data.retrofit.model.DetailsResponse
import com.example.data.retrofit.model.FlashSaleResponse
import com.example.data.retrofit.model.LatestResponse
import com.example.data.retrofit.model.SearchResponse
import retrofit2.http.GET

interface ProductApi {

    @GET("v3/a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getAllFlashSale(): FlashSaleResponse

    @GET("v3/cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getAllLatest(): LatestResponse

    @GET("v3/4c9cd822-9479-4509-803d-63197e5a9e19")
    suspend fun getWords(): SearchResponse

    @GET("v3/f7f99d04-4971-45d5-92e0-70333383c239")
    suspend fun getPhotos(): DetailsResponse
}