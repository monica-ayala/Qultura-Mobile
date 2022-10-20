package com.example.qulturapp.view.sesion

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.qulturapp.R
import com.example.qulturapp.viewmodel.sesion.SesionViewModel
import java.util.regex.Pattern

class ActivitySignUp: AppCompatActivity() {
    private lateinit var usuario: EditText
    private lateinit var correo: EditText
    private lateinit var contrasenia: EditText
    private lateinit var confirmaContrasenia: EditText
    private lateinit var botonSignUp: Button
    private lateinit var textoIniciaSesion: TextView

    private val sesionViewModel = SesionViewModel()

    private fun mensajeInfoIncompleta() {
        Toast.makeText(applicationContext,"Por favor completa los campos que se indican",
            Toast.LENGTH_SHORT)
            .show()
    }

    private fun mensajeInfoRepetida() {
        Toast.makeText(applicationContext,"Este correo ya se encuentra en uso",
            Toast.LENGTH_SHORT)
            .show()
    }

    private fun mensajeErrorConexion() {
        Toast.makeText(applicationContext,"Ha ocurrido un error de conexión",
            Toast.LENGTH_SHORT)
            .show()
    }

    private fun guardarUsuario() {
        when {
            !validaInfo() -> mensajeInfoIncompleta()
            else -> sesionViewModel.guardarUsuario(usuario.text.toString(),
                correo.text.toString(),
                contrasenia.text.toString())
        }
    }

    //Validación de la información ingresada
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

    private fun revisarCuenta(inicia: Boolean?) {
        when(inicia) {
            true -> iniciaPaginaSignIn()
            false -> {
                sesionViewModel.usuarioCreado.postValue(null)
                mensajeInfoRepetida()
            }
            else -> {}
        }
    }

    private fun iniciaPaginaSignIn() {
        val intentSignIn = Intent(this, ActivitySignIn::class.java)
        startActivity(intentSignIn)
    }

    private fun setListeners() {
        sesionViewModel.usuarioCreado.observe(this, Observer {
            revisarCuenta(it)
        })
        sesionViewModel.statusConexion.observe(this, Observer {
            if(it == false) {
                mensajeErrorConexion()
            }
        })
        botonSignUp.setOnClickListener {
            guardarUsuario()
        }
        textoIniciaSesion.setOnClickListener {
            iniciaPaginaSignIn()
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
        textoIniciaSesion = findViewById(R.id.text_toSignIn)

        setListeners()
    }

    private fun esCorreo(cadena: String): Boolean{
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(cadena).matches()
    }
}