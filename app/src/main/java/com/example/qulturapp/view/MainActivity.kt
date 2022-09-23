package com.example.qulturapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qulturapp.R
import com.example.qulturapp.view.Info.ActivityInfo
import com.example.qulturapp.view.emergencia.EmergenciaActivity
import com.example.qulturapp.view.mapas.ActivityMap
import com.example.qulturapp.view.sesion.ActivitySignIn
import com.example.qulturapp.view.solicitudes.ActivitySolicitudes

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val intentSignIn = Intent(this, ActivitySignIn::class.java)
        val intentSignIn = Intent(this, EmergenciaActivity::class.java)
        startActivity(intentSignIn)
    }
}