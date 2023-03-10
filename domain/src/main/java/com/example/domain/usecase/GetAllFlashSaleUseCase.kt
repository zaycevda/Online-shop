package com.example.domain.usecase

import com.example.domain.repository.ProductRepository

class GetAllFlashSaleUseCase(private val productRepository: ProductRepository) {

    suspend fun execute() = productRepository.getAllFlashSale()
}