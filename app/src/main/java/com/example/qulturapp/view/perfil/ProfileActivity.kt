package com.example.qulturapp.view.perfil

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R
import com.example.qulturapp.databinding.ActivityProfileBinding
import com.example.qulturapp.model.sesion.UsuarioActual
import com.example.qulturapp.view.sesion.ActivitySignIn

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Assign values
        val setUsuarioActual : TextView = binding.nombreUsuario
        setUsuarioActual.text = UsuarioActual.nombre

        val setEmail : TextView = binding.emailUsuario
        setEmail.text = UsuarioActual.correo

        // Log out falso :(
        binding.buttonLogout.setOnClickListener {
            val intent = Intent(this, ActivitySignIn :: class.java)
            startActivity(intent)
        }
    }
}