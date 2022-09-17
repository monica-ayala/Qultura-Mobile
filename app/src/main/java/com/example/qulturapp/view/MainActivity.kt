package com.example.qulturapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qulturapp.R
import com.example.qulturapp.view.sesion.ActivitySignIn
import com.example.qulturapp.view.sesion.ActivitySignUp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentSignIn = Intent(this, ActivitySignIn::class.java)
        startActivity(intentSignIn)
    }
}