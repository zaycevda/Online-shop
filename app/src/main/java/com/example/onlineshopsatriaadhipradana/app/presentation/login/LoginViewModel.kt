package com.example.onlineshopsatriaadhipradana.app.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetCurrentAccountByFirstNameUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
    private val getCurrentAccountByFirstNameUseCase: GetCurrentAccountByFirstNameUseCase
) : ViewModel() {

    private val _alreadyExist = MutableLiveData<Boolean>()
    val alreadyExist: LiveData<Boolean> = _alreadyExist

    fun exist(firstName: String) {
        viewModelScope.launch {
            if (getCurrentAccountByFirstNameUseCase.execute(firstName = firstName) != -1L)
                _alreadyExist.postValue(true)
            else
                _alreadyExist.postValue(false)
        }
    }
}