package com.example.qulturapp.view.Info

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.Info.Guia
import com.example.qulturapp.model.Info.Link
import com.example.qulturapp.viewmodel.Informacion.GuiasListAdapter
import com.example.qulturapp.viewmodel.Informacion.GuiasViewModel
import com.example.qulturapp.viewmodel.Informacion.LinksListAdapter
import com.example.qulturapp.viewmodel.Informacion.LinksViewModel

class ActivityInfo: AppCompatActivity() {
    private val linksViewModel = LinksViewModel()
    private lateinit var adapter: LinksListAdapter
    private val guiasViewModel = GuiasViewModel()
    private lateinit var adapterGuias: GuiasListAdapter

    private fun initializeList(list:List<Link>){
        adapter = LinksListAdapter(list)

        val layoutManager = LinearLayoutManager(this)
        val rvLinks = findViewById<RecyclerView>(R.id.rv_list_links)
        rvLinks.layoutManager = layoutManager
        rvLinks.adapter = adapter
    }

    private fun initializeGuias(list:List<Guia>){
        adapterGuias = GuiasListAdapter(list)

        val layoutManager = LinearLayoutManager(this)
        val rvGuias = findViewById<RecyclerView>(R.id.rv_list_guias)
        rvGuias.layoutManager = layoutManager
        rvGuias.adapter = adapterGuias
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        linksViewModel.agregaLink()
        guiasViewModel.agregaGuia()
        initializeList(linksViewModel.listaLinks.toList())
        initializeGuias(guiasViewModel.listaGuias.toList())
    }
}