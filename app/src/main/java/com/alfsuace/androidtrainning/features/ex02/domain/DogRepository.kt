package com.alfsuace.androidtrainning.features.ex02.domain

import com.alfsuace.androidtrainning.app.Either
import com.alfsuace.androidtrainning.app.ErrorApp


interface DogRepository {
    //fun save(input: SaveDogUseCase.Input): Either<ErrorApp, Boolean>
    fun obtain(): Either<ErrorApp, Dog>
}