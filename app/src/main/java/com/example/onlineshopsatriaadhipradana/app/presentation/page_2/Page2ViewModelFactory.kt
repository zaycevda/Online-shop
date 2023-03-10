package com.example.onlineshopsatriaadhipradana.app.presentation.page_2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetDetailsUseCase

class Page2ViewModelFactory(private val getDetailsUseCase: GetDetailsUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        if (modelClass.isAssignableFrom(Page2ViewModel::class.java))
            Page2ViewModel(getDetailsUseCase = getDetailsUseCase) as T
        else
            throw IllegalArgumentException("SignInPageViewModel Not Found")
}