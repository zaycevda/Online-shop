package com.example.onlineshopsatriaadhipradana.app.di

import android.content.Context
import com.example.domain.usecase.*
import com.example.onlineshopsatriaadhipradana.app.presentation.login.LoginViewModelFactory
import com.example.onlineshopsatriaadhipradana.app.presentation.page_1.Page1ViewModelFactory
import com.example.onlineshopsatriaadhipradana.app.presentation.page_2.Page2ViewModelFactory
import com.example.onlineshopsatriaadhipradana.app.presentation.sign_in_page.SignInPageViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    fun provideSignInPageViewModelFactory(
        createAccountUseCase: CreateAccountUseCase,
        getCurrentAccountByEmailUseCase: GetCurrentAccountByEmailUseCase,
        getCurrentAccountByFirstNameUseCase: GetCurrentAccountByFirstNameUseCase
    ) = SignInPageViewModelFactory(
        createAccountUseCase = createAccountUseCase,
        getCurrentAccountByEmailUseCase = getCurrentAccountByEmailUseCase,
        getCurrentAccountByFirstNameUseCase = getCurrentAccountByFirstNameUseCase
    )

    @Provides
    fun providePage1ViewModelFactory(
        getAllLatestUseCase: GetAllLatestUseCase,
        getAllFlashSaleUseCase: GetAllFlashSaleUseCase,
        getWordsUseCase: GetWordsUseCase
    ) = Page1ViewModelFactory(
        getAllLatestUseCase = getAllLatestUseCase,
        getAllFlashSaleUseCase = getAllFlashSaleUseCase,
        getWordsUseCase = getWordsUseCase
    )

    @Provides
    fun provideLoginViewModelFactory(
        getCurrentAccountByFirstNameUseCase: GetCurrentAccountByFirstNameUseCase
    ) = LoginViewModelFactory(
        getCurrentAccountByFirstNameUseCase = getCurrentAccountByFirstNameUseCase
    )

    @Provides
    fun providePage2ViewModelFactory(
        getDetailsUseCase: GetDetailsUseCase
    ) = Page2ViewModelFactory(
        getDetailsUseCase = getDetailsUseCase
    )
}