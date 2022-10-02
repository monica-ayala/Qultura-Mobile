package com.example.qulturapp.view.configuracion

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.qulturapp.R
import com.example.qulturapp.databinding.ActivityConfigurationBinding
import com.example.qulturapp.model.sesion.Usuario
import com.example.qulturapp.model.sesion.UsuarioActual
import com.example.qulturapp.view.emergencia.EmergenciaActivity
import com.example.qulturapp.view.perfil.ProfileActivity
import com.example.qulturapp.view.sesion.ActivitySignIn
import com.example.qulturapp.view.solicitudes.ActivitySolicitudes

class ActivityConfiguration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuration)

        // Variable declaration
        val button_profile = findViewById<LinearLayout>(R.id.profile_access_button)
        val button_solicitudes = findViewById<LinearLayout>(R.id.solicitudes_access_button)
        val button_emergency = findViewById<LinearLayout>(R.id.emergency_access_button)
        val switchTheme = findViewById<Switch>(R.id.darkmode_switch)

        val sharedPreferences : SharedPreferences = getSharedPreferences("Save", MODE_PRIVATE)
        val editor : SharedPreferences.Editor = getSharedPreferences("Save", MODE_PRIVATE).edit()
        switchTheme.setChecked(sharedPreferences.getBoolean("Value", false))

        fun mensajePerfil() {
            Toast.makeText(applicationContext,"Inicia sesión para consultar tu perfil",
                Toast.LENGTH_SHORT)
                .show()
        }

        fun mensajeSolicitudes() {
            Toast.makeText(applicationContext,"Inicia sesión para consultar tus solicitudes",
                Toast.LENGTH_SHORT)
                .show()
        }

        if (UsuarioActual.correo == "") {
            button_profile.setOnClickListener {
                mensajePerfil()
                val intent = Intent(this, ActivitySignIn::class.java)
                startActivity(intent)
            }
        } else {
            button_profile.setOnClickListener {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }
        }

        if (UsuarioActual.correo == "") {
            button_solicitudes.setOnClickListener {
                mensajeSolicitudes()
                val intent = Intent(this, ActivitySignIn::class.java)
                startActivity(intent)
            }
        } else {
            button_solicitudes.setOnClickListener {
                val intent = Intent(this, ActivitySolicitudes::class.java)
                startActivity(intent)
            }
        }

        button_emergency.setOnClickListener {
            val intent = Intent(this, EmergenciaActivity::class.java)
            startActivity(intent)
        }

        switchTheme.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                editor.putBoolean("Value", true)
                editor.apply()
                switchTheme.setChecked(true)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor.putBoolean("Value", false)
                editor.apply()
                switchTheme.setChecked(false)
            }
        }
    }
}