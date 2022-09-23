package com.example.qulturapp.view.Info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.qulturapp.R

class GuiaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guia)
        if(intent.extras != null){
            val guiaTitle = findViewById<TextView>(R.id.tv_guia_title)
            val guiaDescription = findViewById<TextView>(R.id.tv_guia_desc)
            val guiaTip = findViewById<TextView>(R.id.tv_guia_tip)

            val nombre : String? = intent.getStringExtra("name")
            val description : String? = intent.getStringExtra("description")
            val tip : String? = intent.getStringExtra("tip")

            guiaTitle.text = nombre
            guiaDescription.text = description
            guiaTip.text = tip

        }
    }
}