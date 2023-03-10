package com.example.onlineshopsatriaadhipradana.app.presentation.page_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.retrofit.model.DetailsResponse
import com.example.domain.usecase.GetDetailsUseCase
import com.example.onlineshopsatriaadhipradana.app.utils.toDetailsResponse
import kotlinx.coroutines.launch

class Page2ViewModel(private val getDetailsUseCase: GetDetailsUseCase) : ViewModel() {

    private val _details = MutableLiveData<DetailsResponse?>()
    val details: LiveData<DetailsResponse?> = _details

    fun getDetails() {
        viewModelScope.launch {
            val details = getDetailsUseCase.execute()
            val detailsResponse = details?.toDetailsResponse()
            _details.postValue(detailsResponse)
        }
    }

    private val _result = MutableLiveData<Int>()
    val result: LiveData<Int> = _result

    fun counting() {

    }
}