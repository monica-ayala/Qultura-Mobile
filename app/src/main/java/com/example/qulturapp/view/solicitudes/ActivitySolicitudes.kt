package com.example.qulturapp.view.solicitudes

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.viewmodel.solicitudes.SolicitudesListAdapter
import com.example.qulturapp.model.solicitudes.SolicitudLista
import com.example.qulturapp.view.museum.ListMuseum
import com.example.qulturapp.viewmodel.solicitudes.SolicitudesViewModel

class ActivitySolicitudes: AppCompatActivity() {
    private val solicitudesViewModel = SolicitudesViewModel()
    private lateinit var adapter: SolicitudesListAdapter

    private fun mensajeErrorConexion() {
        Toast.makeText(applicationContext,"Ha ocurrido un error de conexión",
            Toast.LENGTH_SHORT)
            .show()
    }

    private fun initializeList(list:List<SolicitudLista>) {
        adapter = SolicitudesListAdapter(list, this)

        val layoutManager = LinearLayoutManager(this)
        val rvSolicitudes = findViewById<RecyclerView>(R.id.rv_list_solicitudes)
        rvSolicitudes.layoutManager = layoutManager
        rvSolicitudes.adapter = adapter

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_solicitudes)
        solicitudesViewModel.listaSolicitudes.observe(this, Observer {
            initializeList(it)
        })
        solicitudesViewModel.statusConexion.observe(this, Observer {
            if(it == false) {
                mensajeErrorConexion()
            }
        })

        solicitudesViewModel.agregaSolicitudes()

        val listbtn = findViewById<View>(R.id.rbtn)
        listbtn.setOnClickListener{
            val intent = Intent(this, ListMuseum::class.java)
            startActivity(intent)
        }
    }
}