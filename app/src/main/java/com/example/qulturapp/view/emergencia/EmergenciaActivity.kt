package com.example.qulturapp.view.emergencia

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.qulturapp.R
import com.example.qulturapp.databinding.ActivityEmergenciaBinding



class EmergenciaActivity : AppCompatActivity() {

    val REQUEST_PHONE_CALL= 1
    var phoneNumber = "4422519850"

    private lateinit var binding: ActivityEmergenciaBinding
    private var i: Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityEmergenciaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val items = listOf("Museo de Arte de Querétaro", "Secretaría de Cultura", "Galería Libertad")
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        binding.dropdownMenu.setAdapter(adapter)

        binding.dropdownMenu.addTextChangedListener(object : TextWatcher {

            // Basado en el texto del dropDownMenu el numero de telefono cambia
            override fun afterTextChanged(s: Editable) {
                if (binding.dropdownMenu.getText().toString()=="Museo de Arte de Querétaro"){
                    phoneNumber = "4422122357"

                }
                else if (binding.dropdownMenu.getText().toString()=="Secretaría de Cultura"){
                    phoneNumber = "4422519850"

                }
                else if (binding.dropdownMenu.getText().toString()=="Galería Libertad"){
                    phoneNumber = "4422142358"
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {}
        })

        //ClickListener del boton de llamada el cual debe ser presionado
        //2 veces para hacer la llamada
        binding.panicBtn.setOnClickListener{
             i++
            val handler = Handler()

            handler.postDelayed ({
                if (i==1){
                    Toast.makeText(this@EmergenciaActivity, "DEBE PRESIONAR EL BOTON 2 VECES PARA HACER LA LLAMADA", Toast.LENGTH_SHORT).show()
                    buildToastMessageOnce()
                }else if (i == 2){
                    buildToastMessageTwice()
                     Toast.makeText(this@EmergenciaActivity, "Has presionado el boton 2 veces", Toast.LENGTH_SHORT).show()
                    if (ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),REQUEST_PHONE_CALL )
                    }else {
                        initiateCall()
                    }
                }
                i=0
                binding.btnDescEmergencia.setText("Presiona 2 veces seguidas el botón para solicitar asistencia ")
            }, 500)


        }

    }

     //  Intent ACTION_CALL Acción de la actividad permite realizar una
     //  llamada a alguien especificado por los datos
    @SuppressLint("MissingPermission")
    private fun initiateCall(){
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:"+ phoneNumber)
        startActivity(callIntent)
    }

    // revisa que el codigo recibido sea igual al
    // codigo correspondiente con el permiso para llamar
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PHONE_CALL)initiateCall()
    }

    // objetos utilizados para las pruebas automatizadas
    companion object{
        fun buildToastMessageTwice(): String{
            return "Has presionado el boton 2 veces"

        }
        fun buildToastMessageOnce(): String{
            return "Debe presionar el boton 1 vez más"

        }
    }

}