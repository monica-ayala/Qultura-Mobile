package com.example.qulturapp.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R
import com.example.qulturapp.model.MuseumListAdapter
import com.example.qulturapp.model.MuseumResults
import com.example.qulturapp.view.sesion.ActivitySignIn
import com.example.qulturapp.viewmodel.MusesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var musList:List<MuseumResults>

    private lateinit var adapter: MuseumListAdapter

    private val viewmodel: MusesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentSignIn = Intent(this, ActivitySignIn::class.java)

        viewmodel.onCreate()
        viewmodel.searchMuseumList()

    }

}
