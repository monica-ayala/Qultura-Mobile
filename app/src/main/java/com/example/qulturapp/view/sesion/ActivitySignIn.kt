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
import com.example.qulturapp.view.configuracion.ActivityConfiguration
import com.example.qulturapp.view.museum.ListMuseum
import com.example.qulturapp.view.perfil.ProfileActivity
import com.example.qulturapp.view.solicitudes.ActivityHorario
import com.example.qulturapp.view.solicitudes.ActivitySolicitudes
import com.example.qulturapp.viewmodel.sesion.SesionViewModel
import java.util.regex.Pattern


class ActivitySignIn: AppCompatActivity() {
    private lateinit var correo: EditText
    private lateinit var contrasenia: EditText

    private val sesionViewModel = SesionViewModel()

    private lateinit var botonSignIn: Button
    private lateinit var  textoCrearCuenta: TextView

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

    private fun mensajeErrorConexion() {
        Toast.makeText(applicationContext,"Ha ocurrido un error de conexión",
            Toast.LENGTH_SHORT)
            .show()
    }

    private fun iniciaSesion() {
        when {
            !validaInfo() -> mensajeInfoIncompleta()
            else -> sesionViewModel.validaUsuario(correo.text.toString(), contrasenia.text.toString() )
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

    private fun ingresarAplicacion(inicia: Boolean?) {
        when(inicia) {
            true -> iniciaPaginaPrincipal()
            false -> {
                sesionViewModel.sesionIniciada.postValue(null)
                mensajeErrorDatos()
                }
            else -> {}
        }
    }

    private fun iniciaPaginaPrincipal() {
        val intentSolicitudes = Intent(this, ProfileActivity::class.java)
        startActivity(intentSolicitudes)
    }

    private fun iniciaPaginaSignUp() {
        val intentSolicitudes = Intent(this, ActivitySignUp::class.java)
        startActivity(intentSolicitudes)
    }

    private fun setListeners() {
        sesionViewModel.sesionIniciada.observe(this, Observer {
            ingresarAplicacion(it)
        })
        sesionViewModel.statusConexion.observe(this, Observer {
            if(it == false) {
                mensajeErrorConexion()
            }
        })
        botonSignIn.setOnClickListener {
            iniciaSesion()
        }
        textoCrearCuenta.setOnClickListener {
            iniciaPaginaSignUp()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        botonSignIn = findViewById(R.id.button_signin)
        correo = findViewById(R.id.edit_text_email)
        contrasenia = findViewById(R.id.edit_text_pass)
        textoCrearCuenta = findViewById(R.id.text_toSignUp)

        setListeners()
    }

    private fun esCorreo(cadena: String): Boolean{
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(cadena).matches()
    }
}