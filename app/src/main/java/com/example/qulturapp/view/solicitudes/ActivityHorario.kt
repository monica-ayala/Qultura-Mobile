package com.example.qulturapp.view.solicitudes

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.horarios.Horario
import com.example.qulturapp.viewmodel.solicitudes.CalendarAdapter
import com.example.qulturapp.viewmodel.solicitudes.HorarioListAdapter
import com.example.qulturapp.viewmodel.solicitudes.HorarioViewModel
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

class ActivityHorario: AppCompatActivity(){
    //Horario
    private val HorarioViewModel = HorarioViewModel()
    private lateinit var adapter: HorarioListAdapter


    private fun initializeList(list:List<Horario>){
        adapter = HorarioListAdapter(list, this, HorarioViewModel)
        val layoutManager = GridLayoutManager(this, 5)
        val rvHorarios = findViewById<RecyclerView>(R.id.rv_list_horarios)

        rvHorarios.layoutManager = layoutManager
        rvHorarios.adapter = adapter

    }

    //Calendario

    private lateinit var selectedDate:LocalDate
    private lateinit var monthYearText:TextView

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setMonthView(){
        val rvCalendar = findViewById<RecyclerView>(R.id.rv_calendarselect)
        monthYearText = findViewById<TextView>(R.id.tv_textoMes)

        monthYearText.text = (monthYearFromDate(selectedDate))
        HorarioViewModel.monthYear_selected = monthYearText.text as String
        val daysInMonth = daysInMonthArray(selectedDate)
        val calendarAdapter = CalendarAdapter(daysInMonth.toList(), this, HorarioViewModel)
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
        val formatter : DateTimeFormatter = (DateTimeFormatter.ofPattern("MMMM yyyy"))
        return date.format(formatter)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun previousMonthAction(view : View){
        selectedDate = selectedDate.minusMonths(1)
        setMonthView()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun nextMonthAction(view : View){
        selectedDate = selectedDate.plusMonths(1)
        setMonthView()
    }

    //

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_registra_solicitud)
        selectedDate = LocalDate.now()
        setMonthView()

        HorarioViewModel.agregaHorarios()
        initializeList(HorarioViewModel.listaHorario.toList())

        // on click boton siguiente
        val boton_siguiente = findViewById<Button>(R.id.boton_siguiente)
        boton_siguiente.setOnClickListener{
            if(HorarioViewModel.day_selected != null && HorarioViewModel.hora_selected != null && HorarioViewModel.monthYear_selected != null){
                val intentRegistrar_Horario2 = Intent(this, ActivityHorario2::class.java)
                startActivity(intentRegistrar_Horario2)
            }
        }
    }
}
