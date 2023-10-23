package com.alfsuace.androidtrainning.features.ex02.presentation

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.alfsuace.androidtrainning.R


import com.alfsuace.androidtrainning.features.ex02.data.DogDataRepository
import com.alfsuace.androidtrainning.features.ex02.data.local.XmlLocalDataSource
import com.alfsuace.androidtrainning.features.ex02.domain.GetDogUseCase

class Ex02FormActivity : AppCompatActivity(){


    val viewModel: Ex02FormViewModel by lazy {
        Ex02FormViewModel(
            //SaveDogUseCase(DogDataRepository(XmlLocalDataSource(this))),
            GetDogUseCase(DogDataRepository(XmlLocalDataSource(this)))
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex02_form)
        //setupView()
        //setupObservers()
        viewModel.loadDog()
    }

//    private fun setupView() {
//        val actionButton = findViewById<Button>(R.id.action_save)
//        actionButton.setOnClickListener {
//            viewModel.saveDog(getNameInput(), getDescriptionInput(), getGenreInput(), getDateBorn())
//        }
//    }

    private fun getNameInput(): String =
        findViewById<EditText>(R.id.input_name).text.toString()

    private fun getSurnameInput(): String =
        findViewById<EditText>(R.id.input_surname).text.toString()

    private fun getAgeInput(): String =
        findViewById<EditText>(R.id.input_birthdate).text.toString()

//    private fun setupObservers() {
//        val observer = Observer<Ex02FormViewModel.UiState> {
//            //Código al notificar el observador
//            it.dog?.apply {
//                bindData(this)
//            }
//        }
//        viewModel.uiState.observe(this, observer)
//    }

//    private fun bindData(dog: Dog?) {
//        setNameInput(dog.id)
//        setSurnameInput(dog.name)
//        setAgeInput(dog.description)
//        setGenre
//    }
//
//    private fun setNameInput(name: String) {
//        findViewById<EditText>(R.id.input_name).setText(name)
//    }
//
//    private fun setSurnameInput(surname: String) {
//        findViewById<EditText>(R.id.input_surname).setText(surname)
//    }
//
//    private fun setAgeInput(age: String) {
//        findViewById<EditText>(R.id.input_birthdate).setText(age)
//    }
}
