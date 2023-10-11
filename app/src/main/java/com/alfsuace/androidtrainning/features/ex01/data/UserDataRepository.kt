package com.alfsuace.androidtrainning.features.ex01.data

import com.alfsuace.androidtrainning.app.Either
import com.alfsuace.androidtrainning.app.ErrorApp
import com.alfsuace.androidtrainning.features.ex01.data.local.XmlLocalDataSource
import com.alfsuace.androidtrainning.features.ex01.domain.SaveUserUseCase
import com.alfsuace.androidtrainning.features.ex01.domain.User
import com.alfsuace.androidtrainning.features.ex01.domain.UserRepository

class UserDataRepository(private val localDataSource: XmlLocalDataSource) : UserRepository {

    override fun save(input: SaveUserUseCase.Input): Either<ErrorApp, Boolean> {
        return localDataSource.saveUser(input)
    }

    override fun obtain(): Either<ErrorApp, User> {
        return localDataSource.findUser()
    }
}