package com.example.onlineshopsatriaadhipradana.app.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetCurrentAccountByFirstNameUseCase

class LoginViewModelFactory(
    private val getCurrentAccountByFirstNameUseCase: GetCurrentAccountByFirstNameUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        if (modelClass.isAssignableFrom(LoginViewModel::class.java))
            LoginViewModel(
                getCurrentAccountByFirstNameUseCase = getCurrentAccountByFirstNameUseCase
            ) as T
        else
            throw IllegalArgumentException("LoginViewModel Not Found")
}