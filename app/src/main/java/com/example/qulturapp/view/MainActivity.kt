package com.example.qulturapp.view

import GalleriesViewModel
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R
import com.example.qulturapp.model.museums.MuseumListAdapter
import com.example.qulturapp.model.museums.MuseumResults
import com.example.qulturapp.view.sesion.ActivitySignIn
import com.example.qulturapp.viewmodel.museums.MuseumsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var musList:List<MuseumResults>

    private lateinit var adapter: MuseumListAdapter

    private val viewmodel: MuseumsViewModel by viewModels()

    private val g_viewmodel: GalleriesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentSignIn = Intent(this, ActivitySignIn::class.java)

        viewmodel.onCreate()
        viewmodel.searchMuseumList()
        g_viewmodel.g_onCreate()
        g_viewmodel.searchGalleryList()

    }

}
