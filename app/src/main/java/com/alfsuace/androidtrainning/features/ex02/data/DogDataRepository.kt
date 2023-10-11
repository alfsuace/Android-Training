package com.alfsuace.androidtrainning.features.ex02.data

import com.alfsuace.androidtrainning.app.Either
import com.alfsuace.androidtrainning.app.ErrorApp
import com.alfsuace.androidtrainning.features.ex02.data.local.XmlLocalDataSource
import com.alfsuace.androidtrainning.features.ex02.domain.Dog
import com.alfsuace.androidtrainning.features.ex02.domain.DogRepository

class DogDataRepository(private val localDataSource: XmlLocalDataSource) : DogRepository {

    override fun obtain(): Either<ErrorApp, Dog> {
        return localDataSource.findDog()
    }
}

