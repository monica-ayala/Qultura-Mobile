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

class ActivitySignUp: AppCompatActivity() {
    private lateinit var usuario: EditText
    private lateinit var correo: EditText
    private lateinit var contrasenia: EditText
    private lateinit var confirmaContrasenia: EditText
    private lateinit var botonSignUp: Button

    private val sesionViewModel = SesionViewModel()

    private fun mensajeInfoIncompleta() {
        Toast.makeText(applicationContext,"Por favor completa los campos que se indican",
            Toast.LENGTH_SHORT)
            .show()
    }

    private fun guardarUsuario() {
        if (!validaInfo()) {
            mensajeInfoIncompleta()
        } else {
            sesionViewModel.guardarUsuario(usuario.text.toString(),
                correo.text.toString(),
                contrasenia.text.toString())
        }

    }

    private fun validaInfo(): Boolean {
        val completo = when {
            usuario.text.toString() == "" -> false
            !esCorreo(correo.text.toString()) -> false
            contrasenia.text.toString() == "" -> false
            contrasenia.text.toString() != confirmaContrasenia.text.toString() -> false
            else -> true
        }
        return completo
    }

    private fun setListeners() {
        botonSignUp.setOnClickListener {
            guardarUsuario()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        usuario = findViewById(R.id.edit_text_name)
        correo = findViewById(R.id.edit_text_email)
        contrasenia = findViewById(R.id.edit_text_pass)
        confirmaContrasenia = findViewById(R.id.edit_text_passconfirm)
        botonSignUp = findViewById(R.id.button_signup)

        setListeners()
    }

    private fun esCorreo(cadena: String): Boolean{
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(cadena).matches()
    }
}