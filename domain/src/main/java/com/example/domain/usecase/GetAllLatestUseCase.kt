package com.example.domain.usecase

import com.example.domain.repository.ProductRepository

class GetAllLatestUseCase(private val productRepository: ProductRepository) {

    suspend fun execute() = productRepository.getAllLatest()
}