package com.example.qulturapp.view.museum

import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.museums.Obras
import com.example.qulturapp.model.museums.ObrasProvider
import com.example.qulturapp.viewmodel.museums.ObrasAdapter
import java.io.IOException


class Lounge: AppCompatActivity() {


    //var mediaPlayer : MediaPlayer? = null
    //private val btnPlayAudio : Button = findViewById(R.id.tvObraAudio)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lounge)
        initRecyclerView()

        /*btnPlayAudio.setOnClickListener {
            mediaPlayer = MediaPlayer.create(
                this@Lounge,
                Uri.parse("https://www.tonesmp3.com/ringtones/zara-si-dil-mein-de-jagah-kk-flute.mp3")
            )
            mediaPlayer?.start()
        }*/
    }


    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerObra)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ObrasAdapter(ObrasProvider.obraList)
    }

}