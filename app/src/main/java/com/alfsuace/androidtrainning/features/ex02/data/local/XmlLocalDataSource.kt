package com.alfsuace.androidtrainning.features.ex02.data.local

import android.content.Context
import com.alfsuace.androidtrainning.app.Either
import com.alfsuace.androidtrainning.app.ErrorApp
import com.alfsuace.androidtrainning.app.left
import com.alfsuace.androidtrainning.app.right
import com.alfsuace.androidtrainning.features.ex02.domain.Dog
import com.google.gson.Gson
import java.util.Date

class XmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences("dogs", Context.MODE_PRIVATE)
    private val gson = Gson()

//    fun saveDog(input: SaveDogUseCase.Input): Either<ErrorApp, Boolean> {
//        return try {
//            with(sharedPref.edit()) {
//                val id = (1..100).random()
//                val dog = Dog(id, input.name, input.description, input.dateBorn)
//                val jsonDog = gson.toJson(dog, Dog::class.java)
//                putString(id.toString(), jsonDog)
//                apply()
//            }
//            true.right()
//        } catch (ex: Exception) {
//            ErrorApp.UnknowError.left()
//        }
//    }

    fun findDog(): Either<ErrorApp, Dog> {
        return try {
            Dog(
                sharedPref.getInt("id", 0),
                sharedPref.getString("name", "")!!,
                sharedPref.getString("description", "")!!,
                sharedPref.getString("genre", "")!!,
                Date(sharedPref.getLong("dateBorn", 0))
            ).right()

        } catch (ex: Exception) {
            ErrorApp.UnknowError.left()
        }
    }

    fun deleteDog(dogId: Int){
        sharedPref.edit().remove(dogId.toString()).apply()
    }

    fun getAllDogs(): List<Dog> {
        val mapDogs = sharedPref.all as Map<String, String>
        return mapDogs.values.map{jsonDog->
            gson.fromJson(jsonDog, Dog::class.java)
        }
    }
}