package com.alfsuace.androidtrainning.features.ex01.domain

import com.alfsuace.androidtrainning.app.Either
import com.alfsuace.androidtrainning.app.ErrorApp

interface UserRepository {

    fun save(input: SaveUserUseCase.Input): Either<ErrorApp, Boolean>
    fun obtain(): Either<ErrorApp, User>
}