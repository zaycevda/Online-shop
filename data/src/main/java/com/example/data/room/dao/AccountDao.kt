package com.example.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.room.entity.AccountEntity

@Dao
interface AccountDao {

    @Insert
    suspend fun createAccount(account: AccountEntity)

    @Query("SELECT id FROM account WHERE email = :email")
    suspend fun findByEmail(email: String): Long?

    @Query("SELECT id FROM account WHERE first_name =:firstName")
    suspend fun findByFirstName(firstName: String): Long?
}