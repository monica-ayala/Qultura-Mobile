package com.example.qulturapp.view.museum

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R

class Artwork: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artwork)

        val rbtn = findViewById<View>(R.id.returnObra)
        rbtn.setOnClickListener{
            val intent = Intent(this, Lounge::class.java)
            startActivity(intent)
        }

    }
}