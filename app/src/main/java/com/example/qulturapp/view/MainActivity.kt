package com.example.qulturapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.qulturapp.R
import com.example.qulturapp.view.museum.ListMuseum



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentSignIn = Intent(this, ListMuseum::class.java)
        startActivity(intentSignIn)

    }
}
