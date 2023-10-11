package com.alfsuace.androidtrainning.features.ex01.domain

import com.alfsuace.androidtrainning.app.Either
import com.alfsuace.androidtrainning.app.ErrorApp

class SaveUserUseCase(private val repository: UserRepository) {

    operator fun invoke(input: Input): Either<ErrorApp, Boolean> {
        return repository.save(input);
    }

    data class Input(val username: String, val surname: String, val age: String)
}