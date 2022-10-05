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

        // on below line we are
        // initializing our media player
        mediaPlayer = MediaPlayer()

        playIB.setOnClickListener {

            // on below line we are creating a variable for our audio url
            var audioUrl = "https://qulturaqro.live/uploads/1.01%20Discovery%20of%20Gravitation.mp3"
            // on below line we are setting audio stream
            // type as stream music on below line.
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)

            // on below line we are running a try
            // and catch block for our media player.
            try {
                // on below line we are setting audio
                // source as audio url on below line.
                mediaPlayer.setDataSource(audioUrl)

                // on below line we are
                // preparing our media player.
                mediaPlayer.prepare()

                // on below line we are
                // starting our media player.
                mediaPlayer.start()

            } catch (e: Exception) {

                // on below line we are handling our exception.
                e.printStackTrace()
            }
            // on below line we are displaying a toast message as audio player.
            Toast.makeText(applicationContext, "Audio started playing..", Toast.LENGTH_SHORT).show()

        }

        pauseIB.setOnClickListener {
            // on below line we are checking
            // if media player is playing.
            if (mediaPlayer.isPlaying) {
                // if media player is playing we
                // are stopping it on below line.
                mediaPlayer.stop()

                // on below line we are resetting
                // our media player.
                mediaPlayer.reset()

                // on below line we are calling
                // release to release our media player.
                mediaPlayer.release()

                // on below line we are displaying a toast message to pause audio/
                Toast.makeText(applicationContext, "Audio has been  paused..", Toast.LENGTH_SHORT)
                    .show()

            } else {
                // if audio player is not displaying we are displaying below toast message
                Toast.makeText(applicationContext, "Audio not played..", Toast.LENGTH_SHORT).show()
            }

        }
    }
}