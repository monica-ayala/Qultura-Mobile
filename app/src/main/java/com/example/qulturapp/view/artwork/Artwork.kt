package com.example.qulturapp.view.artwork

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R
import com.example.qulturapp.model.artwork.ArtworkResults
import com.example.qulturapp.view.museum.Lounge
import com.example.qulturapp.viewmodel.artworks.ArtworkListAdapter
import com.example.qulturapp.viewmodel.artworks.ArtworkViewModel

class Artwork: AppCompatActivity() {
    private lateinit var artList:List<ArtworkResults>

    private lateinit var adapter: ArtworkListAdapter

    private val viewmodel: ArtworkViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artwork)
        viewmodel.getObra()
    }
}