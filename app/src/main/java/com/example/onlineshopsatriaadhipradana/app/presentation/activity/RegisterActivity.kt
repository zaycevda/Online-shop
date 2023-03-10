package com.example.onlineshopsatriaadhipradana.app.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.onlineshopsatriaadhipradana.R
import com.example.onlineshopsatriaadhipradana.app.storage.SharedPreferences

class RegisterActivity : AppCompatActivity() {

    private val sharedPreferences by lazy { SharedPreferences(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        sharedPreferences.checkAuth(MainActivity())
    }
}