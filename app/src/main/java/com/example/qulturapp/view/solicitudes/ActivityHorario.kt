package com.example.qulturapp.view.solicitudes

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.horarios.Horario
import com.example.qulturapp.viewmodel.solicitudes.CalendarAdapter
import com.example.qulturapp.viewmodel.solicitudes.HorarioListAdapter
import com.example.qulturapp.viewmodel.solicitudes.HorarioViewModel
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.util.*

class ActivityHorario: AppCompatActivity(){
    //Horario
    private val HorarioViewModel = HorarioViewModel()
    private lateinit var adapter: HorarioListAdapter


    private fun initializeList(list:List<Horario>){
        adapter = HorarioListAdapter(list, this, this, HorarioViewModel, calendarcounter)
        val layoutManager = GridLayoutManager(this, 5)
        val rvHorarios = findViewById<RecyclerView>(R.id.rv_list_horarios)

        rvHorarios.layoutManager = layoutManager
        rvHorarios.adapter = adapter

    }

    //Calendario

    private lateinit var selectedDate:LocalDate
    private lateinit var monthYearText:TextView
    private lateinit var monthYear:String
    private var calendarcounter:Int = 0

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setMonthView(){
        val rvCalendar = findViewById<RecyclerView>(R.id.rv_calendarselect)
        monthYearText = findViewById<TextView>(R.id.tv_textoMes)

        monthYearText.text = (monthYearFromDate(selectedDate))
        HorarioViewModel.monthYear_selected = monthYearText.text as String
        val daysInMonth = daysInMonthArray(selectedDate)
        val calendarAdapter = CalendarAdapter(daysInMonth.toList(), this, HorarioViewModel, calendarcounter,selectedDate)
        val layoutManager_calendar = GridLayoutManager(this, 7)
        rvCalendar.layoutManager = layoutManager_calendar
        rvCalendar.adapter = calendarAdapter
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun daysInMonthArray(date: LocalDate): MutableList<String> {
        var daysInMonthArray = mutableListOf<String>()
        val yearMonth = YearMonth.from(date)
        val daysInMonth = yearMonth.lengthOfMonth()
        val firstOfMonth = selectedDate.withDayOfMonth(1)
        val dayOfWeek = firstOfMonth.dayOfWeek.value

        for(i in 1..42){
           if(i <= dayOfWeek || i > daysInMonth + dayOfWeek){
               daysInMonthArray.add(" ")
           }else{
               daysInMonthArray.add((i - dayOfWeek).toString())
           }
        }
        return daysInMonthArray

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun monthYearFromDate(date: LocalDate):String{

        val formatter : DateTimeFormatter = (DateTimeFormatter.ofPattern("MMMM yyyy", Locale("Es", "ES")))
        val formatter2 : DateTimeFormatter = (DateTimeFormatter.ofPattern("yyyy-MM"))
        monthYear = date.format(formatter2)
        return date.format(formatter)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun previousMonthAction(view : View){
        if (calendarcounter != 0){
            selectedDate = selectedDate.minusMonths(1)
            calendarcounter -= 1
            HorarioViewModel.fecha_check.value = 0
            setMonthView()
        }else{
            val toast = Toast.makeText(applicationContext, "No puedes regresar al pasado", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun nextMonthAction(view : View){
        if(calendarcounter != 2){
            selectedDate = selectedDate.plusMonths(1)
            calendarcounter += 1
            HorarioViewModel.fecha_check.value = 0
            setMonthView()
        }else{
            val toast = Toast.makeText(applicationContext, "No planees tanto al futuro", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    //

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_registra_solicitud)
        selectedDate = LocalDate.now()
        setMonthView()

        HorarioViewModel.agregaHorarios()

        HorarioViewModel.fecha_check.observe(this, Observer {
            initializeList(HorarioViewModel.listaHorario.toList())
        })

        // on click boton siguiente
        val idMuseo = intent.getIntExtra("id_museo",0)
        val boton_siguiente = findViewById<Button>(R.id.boton_siguiente)

        boton_siguiente.setOnClickListener{
            if(HorarioViewModel.day_selected != null && HorarioViewModel.hora_selected != null && HorarioViewModel.monthYear_selected != null){
                val intentRegistrar_Horario2 = Intent(this, ActivityHorario2::class.java)
                intentRegistrar_Horario2.putExtra("day_selected", HorarioViewModel.day_selected)
                intentRegistrar_Horario2.putExtra("hora_selected", HorarioViewModel.hora_selected)
                intentRegistrar_Horario2.putExtra("monthYear_selected", HorarioViewModel.monthYear_selected)
                intentRegistrar_Horario2.putExtra("monthYear", monthYear)
                intentRegistrar_Horario2.putExtra("id_museo", idMuseo)
                startActivity(intentRegistrar_Horario2)
            }else{
                val toast = Toast.makeText(applicationContext, "Datos incompletos", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }
}
