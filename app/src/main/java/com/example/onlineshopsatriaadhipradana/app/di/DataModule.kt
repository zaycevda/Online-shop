package com.example.onlineshopsatriaadhipradana.app.di

import android.content.Context
import com.example.data.retrofit.repository.ProductRepositoryImpl
import com.example.data.retrofit.service.ProductApi
import com.example.data.room.repository.AccountRepositoryImpl
import com.example.domain.repository.AccountRepository
import com.example.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DataModule {

    @Provides
    fun provideAccountRepository(context: Context): AccountRepository =
        AccountRepositoryImpl(context = context)

    @Provides
    fun provideProductRepository(productApi: ProductApi): ProductRepository =
        ProductRepositoryImpl(productApi = productApi)

    @Provides
    fun provideFlashSaleApi(): ProductApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApi::class.java)

    private companion object {
        const val BASE_URL = "https://run.mocky.io/"
    }
}