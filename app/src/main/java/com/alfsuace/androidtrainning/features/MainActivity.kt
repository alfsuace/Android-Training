package com.alfsuace.androidtrainning.features

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.alfsuace.androidtrainning.features.ex01.presentation.Ex01FormActivity
import com.alfsuace.androidtrainning.R
import com.alfsuace.androidtrainning.features.ex02.presentation.Ex02FormActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView((R.layout.activity_main))
        setupView()

    }

    private fun setupView(){
        findViewById<Button>(R.id.action_ex01_form).setOnClickListener {
            startActivity(Intent(this, Ex02FormActivity::class.java))
        }
    }


}