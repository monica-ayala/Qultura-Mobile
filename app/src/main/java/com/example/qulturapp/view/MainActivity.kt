package com.example.qulturapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.qulturapp.R
import com.example.qulturapp.model.database.DbUtil
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

    private val dbUtil = DbUtil(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
<<<<<<< HEAD
        val intentSignIn = Intent(this, Museums::class.java)
=======
        dbUtil.initRoomDatabase()
        val intentSignIn = Intent(this, ActivityInfo::class.java)
>>>>>>> 15907e1e3981c4f1bc3061e24382b0ecd1862302
        startActivity(intentSignIn)

    }
}
