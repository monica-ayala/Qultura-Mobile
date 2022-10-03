package com.example.qulturapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.qulturapp.R
import com.example.qulturapp.view.museum.ListMuseum
import com.example.qulturapp.view.museum.Museum
import com.example.qulturapp.model.museums.MuseumResults
//import com.example.qulturapp.view.eventos.EventoActivity
import com.example.qulturapp.view.lounge.Lounge
import com.example.qulturapp.view.Info.ActivityInfo
import com.example.qulturapp.view.configuracion.ActivityConfiguration
import com.example.qulturapp.view.emergencia.EmergenciaActivity
import com.example.qulturapp.view.mapas.ActivityMap
import com.example.qulturapp.view.perfil.ProfileActivity
import com.example.qulturapp.view.sesion.ActivitySignIn
import com.example.qulturapp.view.solicitudes.ActivityHorario
import com.example.qulturapp.view.sesion.ActivitySignUp
import com.example.qulturapp.view.solicitudes.ActivitySolicitudes
import com.example.qulturapp.model.galleries.GalleryResults
import com.example.qulturapp.view.gallery.Gallery
import com.example.qulturapp.view.museum.Museums
import com.example.qulturapp.viewmodel.museums.MuseumsViewModel
import com.example.qulturapp.viewmodel.galleries.GalleryListAdapter
import com.example.qulturapp.viewmodel.galleries.GalleryViewModel


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentSignIn = Intent(this, ListMuseum::class.java)
        startActivity(intentSignIn)

    }
}
