package com.example.onlineshopsatriaadhipradana.app

import android.app.Application
import com.example.onlineshopsatriaadhipradana.app.di.AppComponent
import com.example.onlineshopsatriaadhipradana.app.di.AppModule
import com.example.onlineshopsatriaadhipradana.app.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}