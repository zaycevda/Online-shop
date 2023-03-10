package com.example.domain.repository

import com.example.domain.model.Details
import com.example.domain.model.FlashSale
import com.example.domain.model.Latest

interface ProductRepository {

    suspend fun getAllLatest(): List<Latest>

    suspend fun getAllFlashSale(): List<FlashSale>

    suspend fun getWords(): List<String>

    suspend fun getDetails(): Details?
}