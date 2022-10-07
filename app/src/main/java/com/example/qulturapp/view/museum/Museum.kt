package com.example.qulturapp.view.museum

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R
import com.example.qulturapp.model.ApiCallerService
import com.example.qulturapp.view.gallery.Gallery
import com.example.qulturapp.view.sesion.ActivitySignUp
import com.example.qulturapp.view.solicitudes.ActivityHorario
import com.example.qulturapp.view.museum.ListMuseum
import com.example.qulturapp.viewmodel.museum.MuseumViewModel
import com.example.qulturapp.viewmodel.solicitudes.HorarioViewModel
import com.squareup.picasso.Picasso


class Museum:AppCompatActivity() {

    private var caller: ApiCallerService = ApiCallerService()

    private val museumViewModel = MuseumViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum)

        val idMuseo = intent.getIntExtra("id", 0)
        val nomMuseo = intent.getStringExtra("nom")
        val ubiMuseo = intent.getStringExtra("ubi")
        val descMuseo = intent.getStringExtra("desc")
        val imgMuseo =  intent.getStringExtra("url")


        val museumName = findViewById<TextView>(R.id.tv_top_bar_text)
        museumName.text = nomMuseo
        val museumUbi = findViewById<TextView>(R.id.tv_direccion_museo)
        museumUbi.text = ubiMuseo
        val museumDesc = findViewById<TextView>(R.id.tv_musDesc)
        museumDesc.text = descMuseo
        val museumProfileImg = findViewById<ImageView>(R.id.profile_image)
        val museumImg = "https://qulturaqro.live/uploads/" + imgMuseo
        Picasso.get().load(museumImg).into(museumProfileImg)
        val museumBgImg = findViewById<ImageView>(R.id.iv_BgImg)
        Picasso.get().load(museumImg).into(museumBgImg)



        val btn: Button = findViewById<View>(R.id.verSalasBtn) as Button
        btn.setOnClickListener{
            val intent = Intent(this, Gallery::class.java)

            intent.putExtra("id", idMuseo)
            intent.putExtra("url", imgMuseo)

            startActivity(intent)
        }
        val rbtn = findViewById<View>(R.id.returnMuseo)
        rbtn.setOnClickListener{
            val intent = Intent(this, ListMuseum::class.java)
            startActivity(intent)
        }
        val solibtn = findViewById<View>(R.id.solicitudBtn)
        solibtn.setOnClickListener{
            val intent = Intent(this, ActivityHorario::class.java)
            intent.putExtra("id_museo", idMuseo)
            startActivity(intent)
        }

        Log.d("IDS:", idMuseo.toString())
        if (nomMuseo != null) {
            Log.d("Nombre:", nomMuseo)
        }
        if (ubiMuseo != null) {
            Log.d("Ubi:", ubiMuseo)
        }
        if (descMuseo != null) {
            Log.d("Des:", descMuseo)
        }
        if(imgMuseo != null) {
            Log.d("url", imgMuseo)
            }

        // ctm github

    }
}