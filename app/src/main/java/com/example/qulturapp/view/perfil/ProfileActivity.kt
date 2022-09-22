package com.example.qulturapp.view.perfil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R
import com.example.qulturapp.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }
}