package com.alfsuace.androidtrainning.features.ex01.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alfsuace.androidtrainning.app.ErrorApp
import com.alfsuace.androidtrainning.features.ex01.domain.GetUserUseCase
import com.alfsuace.androidtrainning.features.ex01.domain.SaveUserUseCase
import com.alfsuace.androidtrainning.features.ex01.domain.User
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class Ex01FormViewModel(
    private val saveUserUseCase: SaveUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun saveUser(name: String, surname: String, date: String) {
        saveUserUseCase(SaveUserUseCase.Input(name, surname, date)).fold(
            { responseError(it) },
            { responseSuccess(it) }
        )
    }

    fun loadUser(){
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

    private fun responseGetUserSuccess(user: User) {
        _uiState.postValue(UiState(user = user))
    }

    data class UiState(
        val errorApp: ErrorApp? = null,
        val isLoading: Boolean = false,
        val user: User? = null
    )
}