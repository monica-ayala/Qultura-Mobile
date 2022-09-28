package com.example.qulturapp.view.emergencia

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.qulturapp.R
import com.example.qulturapp.databinding.ActivityEmergenciaBinding


class EmergenciaActivity : AppCompatActivity() {

    val REQUEST_PHONE_CALL= 1
    var phoneNumber = "1234567810"

    private lateinit var binding: ActivityEmergenciaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityEmergenciaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val items = listOf("Museo de Arte de Querétaro", "Secretaría de Cultura", "Galería Libertad")
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        binding.dropdownMenu.setAdapter(adapter)




        //ClickListener of call button
        binding.panicBtn.setOnClickListener{

            if (ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),REQUEST_PHONE_CALL )
            }else {
                initiateCall()
            }
        }

    }

    @SuppressLint("MissingPermission")
    private fun initiateCall(){
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:"+ phoneNumber)
        startActivity(callIntent)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PHONE_CALL)initiateCall()
    }
}