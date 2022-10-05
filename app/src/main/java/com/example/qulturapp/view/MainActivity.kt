package com.example.qulturapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qulturapp.R
import com.example.qulturapp.model.database.DbUtil
import com.example.qulturapp.view.museum.ListMuseum
//import com.example.qulturapp.view.eventos.EventoActivity


class MainActivity : AppCompatActivity() {

    private val dbUtil = DbUtil(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dbUtil.initRoomDatabase()
        setContentView(R.layout.activity_main)
        val intentSignIn = Intent(this, ListMuseum::class.java)
        startActivity(intentSignIn)

    }
}
