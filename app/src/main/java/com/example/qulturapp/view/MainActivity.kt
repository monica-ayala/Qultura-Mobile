package com.example.qulturapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qulturapp.R
import com.example.qulturapp.model.database.DbUtil
import com.example.qulturapp.view.interactivo.ActivityInteractivoCEART
import com.example.qulturapp.view.interactivo.ActivityInteractivoGaleriasLibertad
import com.example.qulturapp.view.interactivo.ActivityInteractivoMAQRO
//import com.example.qulturapp.view.eventos.EventoActivity
import com.example.qulturapp.view.interactivo.ActivityInterarctivo
import com.example.qulturapp.view.museum.ListMuseum


class MainActivity : AppCompatActivity() {

    private val dbUtil = DbUtil(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentSignIn = Intent(this, ActivityInteractivoMAQRO::class.java)
        dbUtil.initRoomDatabase()
        try {
            dbUtil.initRoomDatabase()
        } catch (e: NumberFormatException) {
            null
        }
        startActivity(intentSignIn)
    }
}
