package com.example.qulturapp.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.qulturapp.R
import com.example.qulturapp.view.museum.ListMuseum
import com.example.qulturapp.view.museum.Museum
import com.example.qulturapp.model.museums.MuseumListAdapter
import com.example.qulturapp.model.museums.MuseumResults
import com.example.qulturapp.view.museum.Lounge
import com.example.qulturapp.view.sesion.ActivitySignIn
import com.example.qulturapp.viewmodel.museums.MuseumsViewModel
import com.example.qulturapp.view.solicitudes.ActivitySolicitudes


class MainActivity : AppCompatActivity() {

    private lateinit var musList:List<MuseumResults>

    private lateinit var adapter: MuseumListAdapter

    private val viewmodel: MuseumsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentSignIn = Intent(this, Lounge::class.java)
        startActivity(intentSignIn)

        viewmodel.onCreate()
        viewmodel.searchMuseumList()

    }

}
