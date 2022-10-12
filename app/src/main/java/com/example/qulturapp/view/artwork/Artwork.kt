package com.example.qulturapp.view.artwork

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R
import com.example.qulturapp.model.artwork.ArtworkResults
import com.example.qulturapp.viewmodel.artworks.ArtworkListAdapter
import com.example.qulturapp.viewmodel.artworks.ArtworkViewModel

class Artwork : AppCompatActivity() {

    private lateinit var artList: List<ArtworkResults>
    private lateinit var adapter: ArtworkListAdapter
    private lateinit var runnable: Runnable

    private var handler = Handler()
    private val viewmodel: ArtworkViewModel by viewModels()

    lateinit var playIB: ImageButton
    lateinit var mediaPlayer: MediaPlayer
    lateinit var seekbar: SeekBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artwork)

        //viewmodel.getObra()

        playIB = findViewById(R.id.idIBPlay)
        seekbar = findViewById(R.id.seekbar)

        mediaPlayer = MediaPlayer()

        var audioUrl = "https://qulturaqro.live/uploads/Red%20Apple.mp3"

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)

        mediaPlayer.setDataSource(audioUrl)

        mediaPlayer.prepare()

        seekbar.progress = 0
        seekbar.max = mediaPlayer.duration

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

        runnable = Runnable {
            seekbar.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable,1000)
        }

        handler.postDelayed(runnable,1000)
        mediaPlayer.setOnCompletionListener {
            mediaPlayer.pause()
            playIB.setImageResource(R.drawable.ic_baseline_play_circle_outline_24)


        }


    }

}