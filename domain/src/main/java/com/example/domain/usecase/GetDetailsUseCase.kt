package com.example.domain.usecase

import com.example.domain.repository.ProductRepository

class GetDetailsUseCase(private val productRepository: ProductRepository) {

    suspend fun execute() = productRepository.getDetails()
}