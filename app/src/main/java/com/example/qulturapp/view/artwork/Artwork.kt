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
import android.media.AudioManager
import android.media.ImageReader
import android.media.MediaPlayer
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast

class Artwork : AppCompatActivity() {

    lateinit var playIB: ImageButton
    lateinit var pauseIB: ImageButton
    lateinit var mediaPlayer: MediaPlayer
    //lateinit var play_pause: ImageView

    private lateinit var artList: List<ArtworkResults>

    private lateinit var adapter: ArtworkListAdapter

    private val viewmodel: ArtworkViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artwork)

        //viewmodel.getObra()

        playIB = findViewById(R.id.idIBPlay)
        pauseIB = findViewById(R.id.idIBPause)

        mediaPlayer = MediaPlayer()

        playIB.setOnClickListener {
                var audioUrl = "https://qulturaqro.live/uploads/1.01%20Discovery%20of%20Gravitation.mp3"
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)

                try {
                    mediaPlayer.setDataSource(audioUrl)

                    mediaPlayer.prepare()

                    mediaPlayer.start()

                } catch (e: Exception) {

                    e.printStackTrace()
                }
                Toast.makeText(applicationContext, "Comienza Reproducción", Toast.LENGTH_SHORT).show()

        }

        pauseIB.setOnClickListener {
            if (mediaPlayer.isPlaying) {

                mediaPlayer.stop()

                mediaPlayer.reset()

                mediaPlayer.release()

                Toast.makeText(applicationContext, "Audio se ha reiniciado", Toast.LENGTH_SHORT)
                    .show()

            } else {
                Toast.makeText(applicationContext, "No hay audio reproduciéndose", Toast.LENGTH_SHORT).show()
            }

        }
    }
}