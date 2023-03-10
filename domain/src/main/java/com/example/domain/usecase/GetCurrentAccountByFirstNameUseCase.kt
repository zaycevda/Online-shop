package com.example.domain.usecase

import com.example.domain.repository.AccountRepository

class GetCurrentAccountByFirstNameUseCase(private val accountRepository: AccountRepository) {

    suspend fun execute(firstName: String) = accountRepository.findByFirstName(firstName = firstName)
}