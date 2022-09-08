package com.example.qulturapp.view.sesion

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R
import com.example.qulturapp.viewmodel.sesion.SesionViewModel

class ActivitySignUp: AppCompatActivity() {
    private lateinit var usuario: EditText
    private lateinit var correo: EditText
    private lateinit var contrasenia: EditText
    private lateinit var confirmaContrasenia: EditText

    private val sesionViewModel = SesionViewModel()

    private fun guardarUsuario() {
        usuario = findViewById(R.id.edit_text_name)
        correo = findViewById(R.id.edit_text_email)
        contrasenia = findViewById(R.id.edit_text_pass)
        confirmaContrasenia = findViewById(R.id.edit_text_passconfirm)

        if(validaInfo()) {
            sesionViewModel.guardarUsuario(usuario.text.toString(), correo.text.toString(), contrasenia.text.toString())
        }

    }

    private fun validaInfo(): Boolean {
        var completo = false

        return completo
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }
}