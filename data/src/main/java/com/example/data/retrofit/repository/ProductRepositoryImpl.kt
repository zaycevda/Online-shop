package com.example.data.retrofit.repository

import com.example.data.retrofit.service.ProductApi
import com.example.data.utils.showLog
import com.example.data.utils.toDetails
import com.example.data.utils.toFlashSale
import com.example.data.utils.toLatest
import com.example.domain.model.Details
import com.example.domain.model.FlashSale
import com.example.domain.model.Latest
import com.example.domain.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepositoryImpl(private val productApi: ProductApi) : ProductRepository {

    override suspend fun getAllLatest() = withContext(Dispatchers.IO) {

        val latestList = ArrayList<Latest>()

        try {
            val latestModelList = productApi.getAllLatest().latest
            val latest = latestModelList.map { it.toLatest() }
            latestList.addAll(latest)
        } catch (e: Exception) {
            showLog(message = e.message.toString())
        }
        return@withContext latestList
    }

    override suspend fun getAllFlashSale() = withContext(Dispatchers.IO) {

        val flashSaleList = ArrayList<FlashSale>()

        try {
            val flashSaleModelList = productApi.getAllFlashSale().flashSale
            val flashSale = flashSaleModelList.map { it.toFlashSale() }
            flashSaleList.addAll(flashSale)
        } catch (e: Exception) {
            showLog(message = e.message.toString())
        }
        return@withContext flashSaleList
    }

    override suspend fun getWords() = withContext(Dispatchers.IO) {

        val words = ArrayList<String>()

        try {
            words.addAll(productApi.getWords().words)
        } catch (e: Exception) {
            showLog(message = e.message.toString())
        }
        return@withContext words
    }

    override suspend fun getDetails() = withContext(Dispatchers.IO) {

        var details: Details? = null

        try {
            val detailsResponse = productApi.getPhotos()
            details = detailsResponse.toDetails()
        } catch (e: Exception) {
            showLog(message = e.message.toString())
        }
        return@withContext details
    }
}