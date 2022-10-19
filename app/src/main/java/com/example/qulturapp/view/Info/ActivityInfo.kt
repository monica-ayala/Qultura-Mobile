package com.example.qulturapp.view.Info

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.Info.Guia
import com.example.qulturapp.model.Info.GuiaLista
import com.example.qulturapp.model.Info.Link
import com.example.qulturapp.model.Info.LinkLista
import com.example.qulturapp.view.interactivo.ActivityInteractivoCEART
import com.example.qulturapp.view.interactivo.ActivityInteractivoGaleriasLibertad
import com.example.qulturapp.view.interactivo.ActivityInteractivoMAQRO
import com.example.qulturapp.view.museum.ListMuseum
import com.example.qulturapp.view.sesion.ActivitySignIn
import com.example.qulturapp.viewmodel.Informacion.GuiasListAdapter
import com.example.qulturapp.viewmodel.Informacion.GuiasViewModel
import com.example.qulturapp.viewmodel.Informacion.LinksListAdapter
import com.example.qulturapp.viewmodel.Informacion.LinksViewModel
//Comment
class ActivityInfo: AppCompatActivity(), GuiasListAdapter.OnGuiaClickListener, LinksListAdapter.OnLinkClickListener {
    private val linksViewModel = LinksViewModel()
    private lateinit var adapter: LinksListAdapter
    private val guiasViewModel = GuiasViewModel()
    private lateinit var adapterGuias: GuiasListAdapter

    private fun initializeList(list:List<LinkLista>){
        adapter = LinksListAdapter(list, this)

        val layoutManager = LinearLayoutManager(this)
        val rvLinks = findViewById<RecyclerView>(R.id.rv_list_links)
        rvLinks.layoutManager = layoutManager
        rvLinks.adapter = adapter
    }

    private fun initializeGuias(list:List<GuiaLista>){
        adapterGuias = GuiasListAdapter(list, this)

        val layoutManager = LinearLayoutManager(this)
        val rvGuias = findViewById<RecyclerView>(R.id.rv_list_guias)
        rvGuias.layoutManager = layoutManager
        rvGuias.adapter = adapterGuias
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
//        linksViewModel.agregaLink()
//        guiasViewModel.agregaGuia()
//        initializeList(linksViewModel.listaLinks.toList())
//        initializeGuias(guiasViewModel.listaGuias.toList())
        guiasViewModel.listaGuias.observe(this) {
            if (it != null) {
                initializeGuias(it)
            }
        }
        guiasViewModel.agregaGuia()
        linksViewModel.listaLinks.observe(this) {
            if (it != null) {
                initializeList(it)
            }
        }
        linksViewModel.agregaLink()

        val museo1 = findViewById<LinearLayout>(R.id.mapa1)
        museo1.setOnClickListener{
            Toast.makeText(this, "MAPA1", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ActivityInteractivoMAQRO::class.java)
            startActivity(intent)
        }

        val museo2 = findViewById<LinearLayout>(R.id.mapa2)
        museo2.setOnClickListener{
            Toast.makeText(this, "MAPA2", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ActivityInteractivoCEART::class.java)
            startActivity(intent)
        }

        val museo3 = findViewById<LinearLayout>(R.id.mapa3)
        museo3.setOnClickListener{
            Toast.makeText(this, "MAPA3", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ActivityInteractivoGaleriasLibertad::class.java)
            startActivity(intent)
        }
    }

    override fun onGuiaClick(name: String, description: String, tip: String, icon: String, video: String, imagen: String) {
        Toast.makeText(this, "La Guia es: $description", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, GuiaActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("description", description)
        intent.putExtra("tip", tip)
        intent.putExtra("icon", icon)
        intent.putExtra("video", video)
        intent.putExtra("imagen", imagen)
        Toast.makeText(this, "La imagen es: $imagen", Toast.LENGTH_SHORT).show()

        startActivity(intent)
    }

    override fun onLinkClick(name: String, url: String) {
        Toast.makeText(this, "El Link es: $name", Toast.LENGTH_SHORT).show()
        val uri: Uri = Uri.parse(name) // missing 'http://' will cause crashed
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

}