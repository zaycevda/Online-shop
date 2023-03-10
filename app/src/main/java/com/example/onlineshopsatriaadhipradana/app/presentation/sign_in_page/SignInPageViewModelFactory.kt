package com.example.onlineshopsatriaadhipradana.app.presentation.sign_in_page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.CreateAccountUseCase
import com.example.domain.usecase.GetCurrentAccountByEmailUseCase
import com.example.domain.usecase.GetCurrentAccountByFirstNameUseCase

class SignInPageViewModelFactory(
    private val createAccountUseCase: CreateAccountUseCase,
    private val getCurrentAccountByEmailUseCase: GetCurrentAccountByEmailUseCase,
    private val getCurrentAccountByFirstNameUseCase: GetCurrentAccountByFirstNameUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        if (modelClass.isAssignableFrom(SignInPageViewModel::class.java))
            SignInPageViewModel(
                createAccountUseCase = createAccountUseCase,
                getCurrentAccountByEmailUseCase = getCurrentAccountByEmailUseCase,
                getCurrentAccountByFirstNameUseCase = getCurrentAccountByFirstNameUseCase
            ) as T
        else
            throw IllegalArgumentException("SignInPageViewModel Not Found")
}