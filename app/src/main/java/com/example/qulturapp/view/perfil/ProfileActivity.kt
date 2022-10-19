package com.example.qulturapp.view.perfil

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R
import com.example.qulturapp.databinding.ActivityProfileBinding
import com.example.qulturapp.model.sesion.Usuario
import com.example.qulturapp.model.sesion.UsuarioActual
import com.example.qulturapp.view.museum.ListMuseum
import com.example.qulturapp.view.sesion.ActivitySignIn

class ProfileActivity : AppCompatActivity() {
    //private lateinit var binding : ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Assign values
        val setCurrentUserName : TextView = findViewById(R.id.nombre_usuario)
        setCurrentUserName.text = UsuarioActual.nombre

        val setCurrentEmail : TextView = findViewById(R.id.email_usuario)
        setCurrentEmail.text = UsuarioActual.correo

        // Log out
        val buttonLogout : Button = findViewById(R.id.button_logout)
        buttonLogout.setOnClickListener {
            UsuarioActual.limpiaInfo()
            val intent = Intent(this, ListMuseum :: class.java)
            startActivity(intent)
        }
    }
}