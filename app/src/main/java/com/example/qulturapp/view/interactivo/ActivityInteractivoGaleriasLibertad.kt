package com.example.qulturapp.view.interactivo

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R

class ActivityInteractivoGaleriasLibertad: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interactivo_gl)

        var mapMuseum : ImageView = findViewById(R.id.imageViewMapMuseum)

        // Boton elevadores
        val btnElevator : Button = findViewById(R.id.btnElevator)
        // Boton escaleras
        val btnStairs : Button = findViewById(R.id.btnStairs)
        // Boton recepcion
        val btnReception : Button = findViewById(R.id.btnReception)
        // Boton baños
        val btnRestroom : Button = findViewById(R.id.btnRestroom)

        btnElevator.setOnClickListener {
            mapMuseum.setImageResource(R.drawable.gl_pb_elevador)
        }

        btnStairs.setOnClickListener {
            mapMuseum.setImageResource(R.drawable.gl_pb_escaleras)
        }

        btnReception.setOnClickListener {
            mapMuseum.setImageResource(R.drawable.gl_pb_recepcion)
        }

        btnRestroom.setOnClickListener {
            mapMuseum.setImageResource(R.drawable.gl_pb_sanitarios)
        }
    }
}