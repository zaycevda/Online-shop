package com.example.data.room.repository

import android.content.Context
import com.example.data.room.db.AppDatabase
import com.example.data.utils.toAccountEntity
import com.example.domain.model.Account
import com.example.domain.repository.AccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AccountRepositoryImpl(private val context: Context) : AccountRepository {

    override suspend fun createAccount(account: Account) {
        withContext(Dispatchers.IO) {
            AppDatabase
                .getDatabase(context = context)
                .accountDao()
                .createAccount(
                    toAccountEntity(account = account)
                )
        }
    }

    override suspend fun findByEmail(email: String) = withContext(Dispatchers.IO) {
        AppDatabase
            .getDatabase(context = context)
            .accountDao()
            .findByEmail(email = email) ?: -1L
    }

    override suspend fun findByFirstName(firstName: String) = withContext(Dispatchers.IO) {
        AppDatabase
            .getDatabase(context = context)
            .accountDao()
            .findByFirstName(firstName = firstName) ?: -1L
    }
}