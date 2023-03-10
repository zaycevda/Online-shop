package com.example.domain.usecase

import com.example.domain.repository.AccountRepository

class GetCurrentAccountByEmailUseCase(private val accountRepository: AccountRepository) {

    suspend fun execute(email: String) = accountRepository.findByEmail(email = email)
}