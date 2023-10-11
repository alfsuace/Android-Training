package com.alfsuace.androidtrainning.features.ex02.data.remote

import com.alfsuace.androidtrainning.app.Either
import com.alfsuace.androidtrainning.app.ErrorApp
import com.alfsuace.androidtrainning.app.right
import com.alfsuace.androidtrainning.features.ex02.domain.Dog
import java.util.Date

class ApiMockRemoteDataSource {

    fun getDogMock(): Either<ErrorApp, Dog> {
        return Dog(1, "Remi", "un diamante por pulir", "hembra", Date()).right()
    }

}
