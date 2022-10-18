package com.example.qulturapp.view.interactivo

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R

class ActivityInteractivoMAQRO: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interactivo_maqro)

        var mapMuseum : ImageView = findViewById(R.id.imageViewMapMuseum)
        var floorChecker = 0

        // Mapa vacio planta baja
        val btnPB : Button = findViewById(R.id.btnFirstFloor)
        // Mapa vacio planta alta
        val btnPA : Button = findViewById(R.id.btnSecondFloor)

        // Boton rampas
        val btnRamp : Button = findViewById(R.id.btnRamp)
        // Boton elevadores
        val btnElevator : Button = findViewById(R.id.btnElevator)
        // Boton escaleras
        val btnStairs : Button = findViewById(R.id.btnStairs)
        // Boton recepcion
        val btnReception : Button = findViewById(R.id.btnReception)
        // Boton oficinas
        val btnOffice : Button = findViewById(R.id.btnOffice)
        // Boton baños
        val btnRestroom : Button = findViewById(R.id.btnRestroom)

        btnPB.setOnClickListener {
            floorChecker = 0
            mapMuseum.setImageResource(R.drawable.maqro_pb_vacio)
        }

        btnPA.setOnClickListener {
            floorChecker = 1
            mapMuseum.setImageResource(R.drawable.maqro_pa_vacio)
        }

        btnRamp.setOnClickListener {
            if(floorChecker == 0) {
                Toast.makeText(applicationContext,"No hay rampas en el primer piso",
                    Toast.LENGTH_SHORT)
                    .show()
                mapMuseum.setImageResource(R.drawable.maqro_pb_vacio)
            } else {
                Toast.makeText(applicationContext,"No hay rampas en el segundo piso",
                    Toast.LENGTH_SHORT)
                    .show()
                mapMuseum.setImageResource(R.drawable.maqro_pa_vacio)
            }
        }

        btnElevator.setOnClickListener {
            if(floorChecker == 0) {
                mapMuseum.setImageResource(R.drawable.maqro_pb_elevador)
            } else {
                mapMuseum.setImageResource(R.drawable.maqro_pa_elevador)
            }
        }

        btnStairs.setOnClickListener {
            if(floorChecker == 0) {
                mapMuseum.setImageResource(R.drawable.maqro_pb_escaleras)
            } else {
                mapMuseum.setImageResource(R.drawable.maqro_pa_escaleras)
            }
        }

        btnReception.setOnClickListener {
            if(floorChecker == 0) {
                mapMuseum.setImageResource(R.drawable.maqro_pb_recepcion)
            } else {
                Toast.makeText(applicationContext,"La recepción se encuentra sólo en el primer piso",
                    Toast.LENGTH_SHORT)
                    .show()
                mapMuseum.setImageResource(R.drawable.maqro_pa_vacio)
            }
        }

        btnOffice.setOnClickListener {
            if(floorChecker == 0) {
                Toast.makeText(applicationContext,"Las oficinas se encuentran en el segundo piso",
                    Toast.LENGTH_SHORT)
                    .show()
                mapMuseum.setImageResource(R.drawable.maqro_pb_vacio)
            } else {
                mapMuseum.setImageResource(R.drawable.maqro_pa_oficinas)
            }
        }

        btnRestroom.setOnClickListener {
            if(floorChecker == 0) {
                mapMuseum.setImageResource(R.drawable.maqro_pb_sanitarios)
            } else {
                mapMuseum.setImageResource(R.drawable.maqro_pa_sanitarios)
            }
        }
    }
}