package com.example.domain.repository

import com.example.domain.model.Account

interface AccountRepository {

    suspend fun createAccount(account: Account)

    suspend fun findByEmail(email: String): Long

    suspend fun findByFirstName(firstName: String): Long
}