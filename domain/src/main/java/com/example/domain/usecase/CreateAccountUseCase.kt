package com.example.domain.usecase

import com.example.domain.model.Account
import com.example.domain.repository.AccountRepository

class CreateAccountUseCase(private val accountRepository: AccountRepository) {

    suspend fun execute(account: Account) {
        accountRepository.createAccount(account = account)
    }
}