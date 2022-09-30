package com.example.qulturapp.view.lounge

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.artwork.ArtworkResults
import com.example.qulturapp.viewmodel.artworks.ArtworkListAdapter
import com.example.qulturapp.viewmodel.artworks.ArtworkViewModel

class Lounge : AppCompatActivity() {
    private val artworkViewModel = ArtworkViewModel()
    private lateinit var adapter: ArtworkListAdapter

    private fun initializeList(list: List<ArtworkResults>) {
        adapter = ArtworkListAdapter(list, this)

        val layoutManager = LinearLayoutManager(this)
        val rvArtwork = findViewById<RecyclerView>(R.id.recyclerObra)
        rvArtwork.layoutManager = layoutManager
        rvArtwork.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lounge)
        artworkViewModel.listaArtwork.observe(this, Observer {
            if (it != null) {
                initializeList(it)
            }
        })
        artworkViewModel.getObra()
    }
}