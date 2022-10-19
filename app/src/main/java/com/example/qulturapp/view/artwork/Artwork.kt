package com.example.qulturapp.view.artwork

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R
import com.example.qulturapp.model.artwork.ArtworkResults
import com.example.qulturapp.viewmodel.artworks.ArtworkListAdapter
import com.example.qulturapp.viewmodel.artworks.ArtworkViewModel
import com.squareup.picasso.Picasso

/**
 * En esta actividad se desarrolla la vista de Obras.
 * Carga los datos de una obra anteriormente seleccionada
 * y añade un reproductor de audio.
 */

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

        playIB = findViewById(R.id.idIBPlay)

        // Se trata como una barra de progreso del audio.
        seekbar = findViewById(R.id.seekbar)

        mediaPlayer = MediaPlayer()

        // Se define la ruta en la que se encuentra el audio, todos estos se guardan en la instancia.
        var audioUrl = "https://qulturaqro.live/uploads/museos/1666117245750-audioMuseo.mp3"

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)

        mediaPlayer.setDataSource(audioUrl)

        mediaPlayer.prepare()

        // Define el límite que la barra tendrá como progreso
        seekbar.max = mediaPlayer.duration

        /**
         * Define el comportamiento que el botón de reproducción del audio tiene.
         *
         * Dentro del "listener" se tiene una función if que detendrá o reanudará el audio
         * dependiendo de si este está o no en reproducción. De igual manera, cambia la imagen
         * del "ImageButton" dependiendo de su estado.
         *
         * Despliega en pantalla una notificación que indica el estado del audio.
         */

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

        /**
         * La función se encarga de modificar el comportamiento que la "SeekBar" tendrá.
         * Si el usuario modifica su posición, el audio cambiará a reflejar la posición del
         * mismo.
         */
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p2) {
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

        // Define el comportamiento del audio una vez que este termina de reproducirse
        handler.postDelayed(runnable, 10)
        mediaPlayer.setOnCompletionListener {
            mediaPlayer.pause()
            playIB.setImageResource(R.drawable.ic_baseline_play_circle_outline_24)


        }

    }

    /**
     * Esta función destruye la vista en caso de que el audio
     * continúe reproduciéndose antes de regresar al listado de obras
     * anterior.
     * Como estas dos vistas se comunican unidas, la función regresa directamente
     * a la vista de salas lo cual puede resultar inconveniente y desorientador.
     */

    /* override fun onDestroy(){
         super.onDestroy()
         if(mediaPlayer.isPlaying){
             mediaPlayer.stop()
             mediaPlayer.reset()
             mediaPlayer.release()
         }
     }*/

}