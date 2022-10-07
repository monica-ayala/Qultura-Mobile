package com.example.qulturapp.view.solicitudes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.qulturapp.viewmodel.solicitudes.HorarioViewModel
import com.example.qulturapp.R
import com.example.qulturapp.model.sesion.UsuarioActual
import com.example.qulturapp.model.horarios.Horario

class ActivityHorario2: AppCompatActivity() {

    private val horarioViewModel = HorarioViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registra_solicitudpt2)
        var dateText = findViewById<TextView>(R.id.tv_infosolicitudes)
        dateText.text = ( "Solicitud para el " + intent.getStringExtra("day_selected") + " de " +intent.getStringExtra("monthYear_selected") + " a las " + intent.getStringExtra("hora_selected") + "\n" + "\n" + dateText.text.toString())

        // Post

        val idMuseo = intent.getIntExtra("id_museo",0)
        val boton_realizarsol = findViewById<Button>(R.id.boton_realizarsolicitud)
        val info_extra = findViewById<EditText>(R.id.et_infoadicional)
        val visitantes = findViewById<EditText>(R.id.et_numbervisitantes)
        val CB_silla = findViewById<CheckBox>(R.id.CB_sillaruedas)
        val CB_guia = findViewById<CheckBox>(R.id.CB_Guia)
        val CB_rampa = findViewById<CheckBox>(R.id.CB_Rampa)
        val CB_interprete = findViewById<CheckBox>(R.id.CB_Interprete)
        val UsuarioActual = UsuarioActual.correo

        horarioViewModel.exitoSolicitud.observe(this, Observer {
            if(it == true) {
                val intentSolicitudes = Intent(this, ActivitySolicitudes::class.java)
                startActivity(intentSolicitudes)
            }
        })

        boton_realizarsol.setOnClickListener{
            if(UsuarioActual == ""){
                val toast = Toast.makeText(applicationContext, "No haz iniciado sesion", Toast.LENGTH_SHORT)
                toast.show()
            }else{
                horarioViewModel.id_museo = idMuseo
                horarioViewModel.day_selected = intent.getStringExtra("day_selected")
                horarioViewModel.monthYear_selected = intent.getStringExtra("monthYear")
                horarioViewModel.hora_selected = intent.getStringExtra("hora_selected")
                horarioViewModel.info_adicinal = info_extra.text.toString()
                horarioViewModel.numVisitantes = visitantes.text.toString()

                if(CB_silla.isChecked){
                    horarioViewModel.necesidades.add(1)
                    horarioViewModel.necesidades_text.add('"' + (CB_silla.text as String) + '"')
                }
                if(CB_rampa.isChecked){
                    horarioViewModel.necesidades.add(3)
                    horarioViewModel.necesidades_text.add('"' + (CB_rampa.text as String) + '"')
                }
                if(CB_guia.isChecked){
                    horarioViewModel.necesidades.add(2)
                    horarioViewModel.necesidades_text.add('"' + (CB_guia.text as String) + '"')
                }
                if(CB_interprete.isChecked){
                    horarioViewModel.necesidades.add(4)
                    horarioViewModel.necesidades_text.add('"' + (CB_interprete.text as String) + '"')
                }

                if(horarioViewModel.numVisitantes != null && horarioViewModel.numVisitantes != ""){
                    horarioViewModel.agregaSolicitud()

                }else{
                    val toast = Toast.makeText(applicationContext, "Selecciona un numero de visitantes", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
        }

    }
}