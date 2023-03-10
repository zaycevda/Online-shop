package com.example.data.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.room.dao.AccountDao
import com.example.data.room.entity.AccountEntity

@Database(entities = [AccountEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        var accountsDatabase: AppDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): AppDatabase {
            if (accountsDatabase == null) {
                accountsDatabase = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "accounts.database"
                ).build()
            }
            return accountsDatabase!!
        }
    }

    abstract fun accountDao(): AccountDao
}