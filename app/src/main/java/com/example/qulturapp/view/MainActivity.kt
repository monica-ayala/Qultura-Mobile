package com.example.qulturapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.qulturapp.R
import com.example.qulturapp.model.database.DbUtil
import com.example.qulturapp.view.museum.Museum
import com.example.qulturapp.model.museums.MuseumResults
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
import com.example.qulturapp.view.eventos.EventoActivity
import com.example.qulturapp.view.gallery.Gallery
import com.example.qulturapp.view.museum.ListMuseum
import com.example.qulturapp.viewmodel.list.MuseumsViewModel
import com.example.qulturapp.viewmodel.galleries.GalleryListAdapter
import com.example.qulturapp.viewmodel.galleries.GalleryViewModel


class MainActivity : AppCompatActivity() {

    private val dbUtil = DbUtil(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
            .getBoolean("isFirstRun", true)

        if (isFirstRun) {
            //show sign up activity
            //startActivity(Intent(this, MainActivity::class.java))
            val intent = Intent(this, ManualActivity::class.java)
            startActivity(intent)
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isFirstRun", false).commit()
        }
        else{
            val intent2 = Intent(this, ListMuseum::class.java)
            startActivity(intent2)
        }
        try {
            dbUtil.initRoomDatabase(2)
        } catch (e: NumberFormatException) {
            null
        }

    }
}
