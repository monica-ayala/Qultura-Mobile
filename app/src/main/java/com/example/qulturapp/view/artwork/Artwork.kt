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
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast

class Artwork : AppCompatActivity() {

    lateinit var playIB: ImageButton
    lateinit var stopIB: ImageButton
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
        //stopIB = findViewById(R.id.idIBStop)

        mediaPlayer = MediaPlayer()

        var audioUrl = "https://qulturaqro.live/uploads/Red%20Apple.mp3"

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)

        mediaPlayer.setDataSource(audioUrl)

        mediaPlayer.prepare()

        playIB.setOnClickListener {

            if (mediaPlayer.isPlaying) {

                playIB.setImageResource(R.drawable.ic_baseline_play_circle_outline_24)
                mediaPlayer.pause()

                Toast.makeText(applicationContext, "Audio se pausa", Toast.LENGTH_SHORT)
                    .show()


            } else {

                    mediaPlayer.start()
                    playIB.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24)

                Toast.makeText(applicationContext, "Audio inicia", Toast.LENGTH_SHORT)
                    .show()

                }
        }



//        stopIB.setOnClickListener {
//
//                mediaPlayer.stop()
//
//                mediaPlayer.reset()
//
//                mediaPlayer.release()
//
//                Toast.makeText(applicationContext, "Audio se ha reiniciado", Toast.LENGTH_SHORT)
//                    .show()
//
//        }
    }
}