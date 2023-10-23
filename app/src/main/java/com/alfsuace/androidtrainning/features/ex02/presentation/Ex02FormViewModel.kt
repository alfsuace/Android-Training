package com.alfsuace.androidtrainning.features.ex02.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alfsuace.androidtrainning.app.ErrorApp
import com.alfsuace.androidtrainning.features.ex02.domain.Dog
import com.alfsuace.androidtrainning.features.ex02.domain.GetDogUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ex02FormViewModel(

    private val getUserUseCase: GetDogUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

//    fun saveDog(name: String, surname: String, date: String) {
//        saveUserUseCase(SaveUserUseCase.Input(name, surname, date)).fold(
//            { responseError(it) },
//            { responseSuccess(it) }
//        )
//    }

    fun loadDog(){
        viewModelScope.launch(Dispatchers.IO) {
            getUserUseCase().fold(
                { responseError(it) },
                { responseGetUserSuccess(it) }
            )
        }
    }

    private fun responseError(errorApp: ErrorApp) {

    }

    private fun responseSuccess(isOk: Boolean) {

    }

    private fun responseGetUserSuccess(dog: Dog) {
        _uiState.postValue(UiState(dog = dog))
    }

    data class UiState(
        val errorApp: ErrorApp? = null,
        val isLoading: Boolean = false,
        val dog: Dog? = null
    )
}