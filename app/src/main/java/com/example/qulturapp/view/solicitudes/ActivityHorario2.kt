package com.example.qulturapp.view.solicitudes

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.viewmodel.solicitudes.HorarioViewModel
import com.example.qulturapp.R
import com.example.qulturapp.model.horarios.Horario

class ActivityHorario2: AppCompatActivity() {

    private val HorarioViewModel = HorarioViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registra_solicitudpt2)
        var dateText = findViewById<TextView>(R.id.tv_infosolicitudes)
        dateText.text = ( "Solicitud para el " + intent.getStringExtra("day_selected") + " de " +intent.getStringExtra("monthYear_selected") + " a las " + intent.getStringExtra("hora_selected") + "\n" + "\n" + dateText.text.toString())

        // Post

        val boton_realizarsol = findViewById<Button>(R.id.boton_realizarsolicitud)
        val info_extra = findViewById<EditText>(R.id.et_infoadicional)
        val visitantes = findViewById<EditText>(R.id.et_numbervisitantes)
        val CB_silla = findViewById<CheckBox>(R.id.CB_sillaruedas)
        val CB_guia = findViewById<CheckBox>(R.id.CB_Guia)
        val CB_rampa = findViewById<CheckBox>(R.id.CB_Rampa)
        val CB_interprete = findViewById<CheckBox>(R.id.CB_Interprete)

        boton_realizarsol.setOnClickListener{

            HorarioViewModel.day_selected = intent.getStringExtra("day_selected")
            HorarioViewModel.monthYear_selected = intent.getStringExtra("monthYear")
            HorarioViewModel.hora_selected = intent.getStringExtra("hora_selected")
            HorarioViewModel.info_adicinal = info_extra.text.toString()
            HorarioViewModel.numVisitantes = visitantes.text.toString()

            if(CB_silla.isChecked){
                HorarioViewModel.necesidades += 1
            }
            if(CB_rampa.isChecked){
                HorarioViewModel.necesidades += 3
            }
            if(CB_guia.isChecked){
                HorarioViewModel.necesidades += 2
            }
            if(CB_interprete.isChecked){
                HorarioViewModel.necesidades += 4
            }

            if(HorarioViewModel.numVisitantes != null && HorarioViewModel.numVisitantes != ""){

            }else{
                val toast = Toast.makeText(applicationContext, "Selecciona un numero de visitantes", Toast.LENGTH_SHORT)
                toast.show()
            }
        }

    }
}