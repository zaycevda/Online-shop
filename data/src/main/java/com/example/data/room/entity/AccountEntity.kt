package com.example.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "account",
    indices = [
        Index("email", unique = true),
        Index("first_name", unique = true)
    ]
)
data class AccountEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(collate = ColumnInfo.NOCASE)
    val email: String,
    @ColumnInfo("first_name")
    val firstName: String,
    @ColumnInfo("last_name")
    val lastName: String
)