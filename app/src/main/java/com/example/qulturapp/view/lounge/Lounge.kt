package com.example.qulturapp.view.lounge

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.artwork.ArtworkResults
import com.example.qulturapp.viewmodel.artworks.ArtworkListAdapter
import com.example.qulturapp.viewmodel.artworks.ArtworkViewModel
import com.squareup.picasso.Picasso

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


        val nomSala = intent.getStringExtra("nom")
        val imgMuseo = intent.getStringExtra("url")
        val descSala = intent.getStringExtra("desc")
        val idSala = intent.getIntExtra("id", 0)

        Log.d("Id_Sala:", idSala.toString())

        artworkViewModel.getObra(idSala)

        val museumName = findViewById<TextView>(R.id.tv_top_bar_text)
        museumName.text = nomSala

        val salaDesc = findViewById<TextView>(R.id.readmore)
        salaDesc.text = descSala

        val obraBgImg = findViewById<ImageView>(R.id.ivSalaBG)
        val obraProfileImg = findViewById<ImageView>(R.id.roundedImageView)
        val museumImg = "https://qulturaqro.live/uploads/museos/" + imgMuseo
        Picasso.get().load(museumImg).into(obraBgImg)
        Picasso.get().load(museumImg).into(obraProfileImg)
    }
}