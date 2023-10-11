package com.alfsuace.androidtrainning.features.ex01.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import com.alfsuace.androidtrainning.features.ex01.data.UserDataRepository
import com.alfsuace.androidtrainning.features.ex01.data.local.XmlLocalDataSource
import com.alfsuace.androidtrainning.features.ex01.domain.GetUserUseCase
import com.alfsuace.androidtrainning.features.ex01.domain.SaveUserUseCase
import com.alfsuace.androidtrainning.features.ex01.domain.User
import com.alfsuace.androidtrainning.R

class Ex01FormActivity : AppCompatActivity() {

    //Para usar esta creación se ha añadido:  implementation "androidx.activity:activity-ktx:1.7.2"
    val viewModel: Ex01FormViewModel by lazy {
        Ex01FormViewModel(
            SaveUserUseCase(UserDataRepository(XmlLocalDataSource(this))),
            GetUserUseCase(UserDataRepository(XmlLocalDataSource(this)))
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex01_form)
        setupView()
        setupObservers()
        viewModel.loadUser()
    }

    private fun setupView() {
        val actionButton = findViewById<Button>(R.id.action_save)
        actionButton.setOnClickListener {
            viewModel.saveUser(getNameInput(), getSurnameInput(), getAgeInput())
        }
    }

    private fun getNameInput(): String =
        findViewById<EditText>(R.id.input_name).text.toString()

    private fun getSurnameInput(): String =
        findViewById<EditText>(R.id.input_surname).text.toString()

    private fun getAgeInput(): String =
        findViewById<EditText>(R.id.input_birthdate).text.toString()

    private fun setupObservers() {
        val observer = Observer<Ex01FormViewModel.UiState> {
            //Código al notificar el observador
            it.user?.apply {
                bindData(this)
            }
        }
        viewModel.uiState.observe(this, observer)
    }

    private fun bindData(user: User) {
        setNameInput(user.username)
        setSurnameInput(user.surname)
        setAgeInput(user.age)
    }

    private fun setNameInput(name: String) {
        findViewById<EditText>(R.id.input_name).setText(name)
    }

    private fun setSurnameInput(surname: String) {
        findViewById<EditText>(R.id.input_surname).setText(surname)
    }

    private fun setAgeInput(age: String) {
        findViewById<EditText>(R.id.input_birthdate).setText(age)
    }
}