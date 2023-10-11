package com.alfsuace.androidtrainning.features.ex02.domain

import com.alfsuace.androidtrainning.app.Either
import com.alfsuace.androidtrainning.app.ErrorApp


class GetDogUseCase (private val repository: DogRepository){
    operator fun invoke(): Either<ErrorApp, Dog> {
        return repository.obtain()
    }
}