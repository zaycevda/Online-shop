package com.example.onlineshopsatriaadhipradana.app.di

import com.example.domain.repository.*
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideCreateAccountUseCase(accountRepository: AccountRepository) =
        com.example.domain.usecase.CreateAccountUseCase(accountRepository = accountRepository)

    @Provides
    fun provideGetCurrentAccountByEmailUseCase(accountRepository: AccountRepository) =
        com.example.domain.usecase.GetCurrentAccountByEmailUseCase(accountRepository = accountRepository)

    @Provides
    fun provideGetCurrentAccountByFirstNameUseCase(accountRepository: AccountRepository) =
        com.example.domain.usecase.GetCurrentAccountByFirstNameUseCase(accountRepository = accountRepository)

    @Provides
    fun provideGetAllLatestUseCase(productRepository: ProductRepository) =
        com.example.domain.usecase.GetAllLatestUseCase(productRepository = productRepository)

    @Provides
    fun provideGetAllFlashSaleUseCase(productRepository: ProductRepository) =
        com.example.domain.usecase.GetAllFlashSaleUseCase(productRepository = productRepository)

    @Provides
    fun provideGetWordsUseCase(productRepository: ProductRepository) =
        com.example.domain.usecase.GetWordsUseCase(productRepository = productRepository)

    @Provides
    fun provideGetDetailsUseCase(productRepository: ProductRepository) =
        com.example.domain.usecase.GetDetailsUseCase(productRepository = productRepository)
}