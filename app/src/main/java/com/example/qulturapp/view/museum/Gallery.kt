package com.example.qulturapp.view.museum

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R

class Gallery: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        val btn: Button = findViewById<View>(R.id.salaUnoBtn) as Button
        btn.setOnClickListener{
            val intent = Intent(this, Lounge::class.java)
            startActivity(intent)
        }
        val rbtn = findViewById<View>(R.id.returnSala)
        rbtn.setOnClickListener{
            val intent = Intent(this, Museum::class.java)
            startActivity(intent)
        }

    }
}