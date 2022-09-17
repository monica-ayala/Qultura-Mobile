package com.example.qulturapp.view.sesion

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R
import com.example.qulturapp.viewmodel.sesion.SesionViewModel
import java.util.regex.Pattern


class ActivitySignIn: AppCompatActivity() {
    private lateinit var correo: EditText
    private lateinit var contrasenia: EditText

    private val sesionViewModel = SesionViewModel()

    private lateinit var botonSignIn: Button

    private fun mensajeInfoIncompleta() {
        Toast.makeText(applicationContext,"Por favor completa los campos que se indican",
            Toast.LENGTH_SHORT)
            .show()
    }

    private fun mensajeErrorDatos() {
        Toast.makeText(applicationContext,"Los datos ingresados son incorrectos",
            Toast.LENGTH_SHORT)
            .show()
    }

    private fun iniciaSesion() {
        when {
            !validaInfo() -> mensajeInfoIncompleta()
            !sesionViewModel.validaUsuario(correo.text.toString(),
                contrasenia.text.toString()) -> mensajeErrorDatos()
            else -> TODO() //Si entra
        }
    }

    private fun validaInfo(): Boolean {
        val completo = when {
            !esCorreo(correo.text.toString()) -> false
            contrasenia.text.toString() == "" -> false
            else -> true
        }
        return completo
    }

    private fun setListeners() {
        botonSignIn.setOnClickListener {
            iniciaSesion()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        botonSignIn = findViewById(R.id.button_signin)
        correo = findViewById(R.id.edit_text_email)
        contrasenia = findViewById(R.id.edit_text_pass)

        setListeners()
    }

    private fun esCorreo(cadena: String): Boolean{
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(cadena).matches()
    }
}