package com.example.qulturapp.view.museum

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R
import com.example.qulturapp.model.ApiCallerService
import com.example.qulturapp.view.gallery.Gallery
import com.example.qulturapp.view.sesion.ActivitySignUp
import com.example.qulturapp.view.solicitudes.ActivityHorario
import com.example.qulturapp.view.museum.ListMuseum
import com.example.qulturapp.viewmodel.museum.MuseumViewModel


class Museum:AppCompatActivity() {

    private val museumViewModel = MuseumViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum)

        val id_museo = intent.getIntExtra("id", 0)

        museumViewModel.getMuseo(id_museo)

        val btn: Button = findViewById<View>(R.id.verSalasBtn) as Button
        btn.setOnClickListener{
            val intent = Intent(this, Gallery::class.java)
            startActivity(intent)
        }
        val rbtn = findViewById<View>(R.id.returnMuseo)
        rbtn.setOnClickListener{
            val intent = Intent(this, ListMuseum::class.java)
            startActivity(intent)
        }
        val solibtn = findViewById<View>(R.id.solicitudBtn)
        solibtn.setOnClickListener{
            //val intent = Intent(this, ActivityHorario::class.java)
            //startActivity(intent)
            Log.d("IDS:", id_museo.toString())
        }

    }
}