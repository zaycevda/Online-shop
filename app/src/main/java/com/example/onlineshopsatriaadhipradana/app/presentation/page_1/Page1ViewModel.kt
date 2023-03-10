package com.example.onlineshopsatriaadhipradana.app.presentation.page_1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.retrofit.model.FlashSaleModel
import com.example.data.retrofit.model.LatestModel
import com.example.domain.usecase.GetAllFlashSaleUseCase
import com.example.domain.usecase.GetAllLatestUseCase
import com.example.domain.usecase.GetWordsUseCase
import com.example.onlineshopsatriaadhipradana.app.utils.toFlashSaleModel
import com.example.onlineshopsatriaadhipradana.app.utils.toLatestModel
import kotlinx.coroutines.*

class Page1ViewModel(
    private val getWordsUseCase: GetWordsUseCase,
    private val getAllLatestUseCase: GetAllLatestUseCase,
    private val getAllFlashSaleUseCase: GetAllFlashSaleUseCase
) : ViewModel() {

    private val _words = MutableLiveData<List<String>>()
    val words: LiveData<List<String>> = _words

    fun getWords() {
        viewModelScope.launch {
            _words.postValue(getWordsUseCase.execute())
        }
    }

    private val _latest = MutableLiveData<List<LatestModel>>()
    val latest: LiveData<List<LatestModel>> = _latest

    fun getAllLatest() {
        viewModelScope.launch {
            val latestList = getAllLatestUseCase.execute()
            val latestModel = latestList.map { it.toLatestModel() }
            _latest.postValue(latestModel)
        }
    }

    private val _flashSale = MutableLiveData<List<FlashSaleModel>>()
    val flashSale: LiveData<List<FlashSaleModel>> = _flashSale

    fun getAllFlashSale() {
        viewModelScope.launch {
            val flashSaleList = getAllFlashSaleUseCase.execute()
            val flashSaleModel = flashSaleList.map { it.toFlashSaleModel() }
            _flashSale.postValue(flashSaleModel)
        }
    }
}