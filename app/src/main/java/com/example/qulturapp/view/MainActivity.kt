package com.example.qulturapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qulturapp.R
import com.example.qulturapp.view.eventos.EventoActivity
import com.example.qulturapp.view.sesion.ActivitySignIn

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentEvento = Intent(this, EventoActivity::class.java)
        startActivity(intentEvento)
    }
}