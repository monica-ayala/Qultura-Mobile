package com.example.qulturapp.view.eventos

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R
import com.squareup.picasso.Picasso

class EventoDetalle : AppCompatActivity(){
    lateinit var fotoEvento: ImageView
    lateinit var nombreEvento: TextView
    lateinit var fechaEvento: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_evento)

        fotoEvento = findViewById(R.id.img_evento)
        nombreEvento = findViewById(R.id.titulo_detalle)
        fechaEvento = findViewById(R.id.fecha_detalle)

        val ligaImg =  "http://3.14.37.4:8080/uploads/" + intent.getStringExtra("img_evento")
        Picasso
            .get()
            .load(ligaImg)
            .resize(0, 2000)
            .into(fotoEvento)

        val fecha = intent.getStringExtra("fecha_evento")
        val lugar = intent.getStringExtra("lugar_evento")

        val anio = fecha?.subSequence(0, 4)
        val mes = fecha?.subSequence(5, 7)
        val dia = fecha?.subSequence(8, 10)


        nombreEvento.text = intent.getStringExtra("nombre_evento")
        fechaEvento.text = "$dia/$mes/$anio en $lugar"


    }
}