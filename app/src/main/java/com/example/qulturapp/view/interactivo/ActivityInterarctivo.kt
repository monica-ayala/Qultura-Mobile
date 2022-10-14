package com.example.qulturapp.view.interactivo

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.app.ActivityCompat
import com.example.qulturapp.R
import com.example.qulturapp.databinding.ActivityInteractivoBinding


class ActivityInterarctivo: AppCompatActivity() {

    private lateinit var binding: ActivityInteractivoBinding
    var color: Int = 0

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInteractivoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button: AppCompatButton = findViewById(R.id.buttonRamp)
        button.setOnClickListener {
            // does not appear at all
            val altColor = 0x00000000
            // blends with red, result is purple
            // val altColor = 0x660000FF
            val nextColor = if (color == Color.RED) altColor else Color.RED
            button.backgroundTintList = ColorStateList.valueOf(nextColor)
            color = nextColor
        }
    }
}