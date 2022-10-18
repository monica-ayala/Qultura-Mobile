package com.example.qulturapp.view.artwork

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R
import com.example.qulturapp.model.artwork.ArtworkResults
import com.example.qulturapp.viewmodel.artworks.ArtworkListAdapter
import com.example.qulturapp.viewmodel.artworks.ArtworkViewModel
import com.squareup.picasso.Picasso

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

        val nomObra = intent.getStringExtra("nom")
        val artworkName = findViewById<TextView>(R.id.tv_top_bar_text)
        artworkName.text = nomObra

        val descObra = intent.getStringExtra("desc")
        val artworkDesc = findViewById<TextView>(R.id.tv_desc_obra)
        artworkDesc.text = descObra

        val fechObra = intent.getStringExtra("fecha")
        val artworkFech = findViewById<TextView>(R.id.tv_fecha_obra)
        artworkFech.text = fechObra

        val autorObra = intent.getStringExtra("autor")
        val artworkAutor = findViewById<TextView>(R.id.tv_autor_obra)
        artworkAutor.text = autorObra

        val imgMuseo = intent.getStringExtra("url")
        val obraProfileImg = findViewById<ImageView>(R.id.roundedImageView)
        val obraBgImg = findViewById<ImageView>(R.id.ivObraBG)
        val museumImg = "https://qulturaqro.live/uploads/" + imgMuseo
        Picasso.get().load(museumImg).into(obraBgImg)
        Picasso.get().load(museumImg).into(obraProfileImg)

        //viewmodel.getObra()

        playIB = findViewById(R.id.idIBPlay)
        seekbar = findViewById(R.id.seekbar)

        mediaPlayer = MediaPlayer()

        var audioUrl = "https://qulturaqro.live/uploads/museos/1666117245750-audioMuseo.mp3"

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)

        mediaPlayer.setDataSource(audioUrl)

        mediaPlayer.prepare()

        //seekbar.progress = 0
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

        seekbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p2){
                    mediaPlayer.seekTo(p1)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        runnable = Runnable {
            seekbar.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable, 10)
        }

        handler.postDelayed(runnable, 10)
        mediaPlayer.setOnCompletionListener {
            mediaPlayer.pause()
            playIB.setImageResource(R.drawable.ic_baseline_play_circle_outline_24)


        }


    }

}