package com.alfsuace.androidtrainning.features.ex01.data.local

import android.content.Context
import com.alfsuace.androidtrainning.app.Either
import com.alfsuace.androidtrainning.app.ErrorApp
import com.alfsuace.androidtrainning.app.left
import com.alfsuace.androidtrainning.app.right
import com.alfsuace.androidtrainning.features.ex01.domain.SaveUserUseCase
import com.alfsuace.androidtrainning.features.ex01.domain.User
import com.google.gson.Gson
import java.lang.Exception

class XmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
    private val gson = Gson()


    fun saveUser(input: SaveUserUseCase.Input): Either<ErrorApp, Boolean> {
        return try {
            with(sharedPref.edit()) {
                val id = (1..100).random()
                val user = User(id, input.username, input.surname, input.age)
                val jsonUser = gson.toJson(user, User::class.java)
                putString(id.toString(), jsonUser)
                apply()
            }
            true.right()
        } catch (ex: Exception) {
            ErrorApp.UnknowError.left()
        }
    }

    fun findUser(): Either<ErrorApp, User> {
        return try {
            User(
                sharedPref.getInt("id", 0),
                sharedPref.getString("username", "")!!,
                sharedPref.getString("surname", "")!!,
                sharedPref.getString("age", "")!!
            ).right()
        } catch (ex: Exception) {
            return ErrorApp.UnknowError.left()
        }
    }

    fun deleteUser(userId: Int){
        sharedPref.edit().remove(userId.toString()).apply()
    }

    fun getAll(): List<Unit> {
        val mapUsers = sharedPref.all as Map<String, String>
        return mapUsers.values.map{jsonUser->
            gson.fromJson(jsonUser, User::class.java)
        }
    }
}