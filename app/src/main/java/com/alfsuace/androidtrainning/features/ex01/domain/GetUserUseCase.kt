package com.alfsuace.androidtrainning.features.ex01.domain

import com.alfsuace.androidtrainning.app.Either
import com.alfsuace.androidtrainning.app.ErrorApp

class GetUserUseCase(private val repository: UserRepository) {

    operator fun invoke(): Either<ErrorApp, User> {
        return repository.obtain()
    }
}