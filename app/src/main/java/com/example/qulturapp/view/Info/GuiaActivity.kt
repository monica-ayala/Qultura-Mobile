package com.example.qulturapp.view.Info

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class GuiaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guia)
        if(intent.extras != null){
            val guiaTitle = findViewById<TextView>(R.id.tv_guia_title)
            val guiaDescription = findViewById<TextView>(R.id.tv_guia_desc)
            val guiaTip = findViewById<TextView>(R.id.tv_guia_tip)
            val guiaIcon = findViewById<ImageView>(R.id.iv_guia_icon)
            var linearLayout = findViewById<LinearLayout>(R.id.ly_guia)
            //val youTubePlayerView = findViewById<YouTubePlayerView>(R.id.youtube)
            val youTubePlayerView = YouTubePlayerView(this)
            lifecycle.addObserver(youTubePlayerView)



            val nombre : String? = intent.getStringExtra("name")
            val description : String? = intent.getStringExtra("description")
            val tip : String? = intent.getStringExtra("tip")
            val icon : String? = intent.getStringExtra("icon")
            val video : String? = intent.getStringExtra("video")

            guiaTitle.text = nombre
            guiaDescription.text = description
            guiaTip.text = tip

            youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    val videoId = video
                    if (videoId != null) {
                        youTubePlayer.cueVideo(videoId, 0f)
                    }
                }
            })
            linearLayout.addView(youTubePlayerView)



        }

    }
}