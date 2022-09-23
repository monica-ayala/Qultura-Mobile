package com.example.qulturapp.view

import GalleryViewModel
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.galleries.GalleryResults
import com.example.qulturapp.model.galleries.SalaProvider
import com.example.qulturapp.view.gallery.Gallery
import com.example.qulturapp.viewmodel.museums.MuseumsViewModel
import com.example.qulturapp.viewmodel.galleries.GalleryListAdapter
import com.example.qulturapp.viewmodel.galleries.SalasAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var musList:List<GalleryResults>

    private lateinit var adapter: GalleryListAdapter

    private val viewmodel: MuseumsViewModel by viewModels()

    private val g_viewmodel: GalleryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentSignIn = Intent(this, Gallery::class.java)
        startActivity(intentSignIn)

        viewmodel.onCreate()
        viewmodel.searchMuseumList()
        g_viewmodel.searchGalleryList()

    }

}
