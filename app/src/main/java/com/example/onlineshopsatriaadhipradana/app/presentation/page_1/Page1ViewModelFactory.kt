package com.example.onlineshopsatriaadhipradana.app.presentation.page_1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetAllFlashSaleUseCase
import com.example.domain.usecase.GetAllLatestUseCase
import com.example.domain.usecase.GetWordsUseCase

class Page1ViewModelFactory(
    private val getWordsUseCase: GetWordsUseCase,
    private val getAllLatestUseCase: GetAllLatestUseCase,
    private val getAllFlashSaleUseCase: GetAllFlashSaleUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        if (modelClass.isAssignableFrom(Page1ViewModel::class.java))
            Page1ViewModel(
                getWordsUseCase = getWordsUseCase,
                getAllLatestUseCase = getAllLatestUseCase,
                getAllFlashSaleUseCase = getAllFlashSaleUseCase
            ) as T
        else
            throw IllegalArgumentException("Page1ViewModel Not Found")
}