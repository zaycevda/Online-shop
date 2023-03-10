package com.example.onlineshopsatriaadhipradana.app.presentation.sign_in_page

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Account
import com.example.domain.usecase.CreateAccountUseCase
import com.example.domain.usecase.GetCurrentAccountByEmailUseCase
import com.example.domain.usecase.GetCurrentAccountByFirstNameUseCase
import kotlinx.coroutines.launch

class SignInPageViewModel(
    private val createAccountUseCase: CreateAccountUseCase,
    private val getCurrentAccountByEmailUseCase: GetCurrentAccountByEmailUseCase,
    private val getCurrentAccountByFirstNameUseCase: GetCurrentAccountByFirstNameUseCase
) : ViewModel() {

    private val _alreadyExist = MutableLiveData<Boolean>()
    val alreadyExist: LiveData<Boolean> = _alreadyExist

    fun createAccount(email: String, firstName: String, lastName: String) {
        viewModelScope.launch {
            val account = Account(
                email = email,
                firstName = firstName,
                lastName = lastName
            )
            createAccountUseCase.execute(account = account)
        }
    }

    fun exist(email: String, firstName: String) {
        viewModelScope.launch {
            if (
                getCurrentAccountByFirstNameUseCase.execute(firstName = firstName) != -1L
                || getCurrentAccountByEmailUseCase.execute(email = email) != -1L
            )
                _alreadyExist.postValue(true)
            else
                _alreadyExist.postValue(false)
        }
    }
}