package com.example.qulturapp.view.museum

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R
import com.example.qulturapp.view.sesion.ActivitySignUp

class Museum:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum)

        val btn: Button = findViewById<View>(R.id.verSalasBtn) as Button
        btn.setOnClickListener{
            val intent = Intent(this, Gallery::class.java)
            startActivity(intent)
        }
        val rbtn = findViewById<View>(R.id.returnMuseo)
        rbtn.setOnClickListener{
            val intent = Intent(this, ListMuseum::class.java)
            startActivity(intent)
        }
        val solibtn = findViewById<View>(R.id.returnMuseo)
        solibtn.setOnClickListener{
            val intent = Intent(this, ActivitySignUp::class.java)
            startActivity(intent)
        }

    }
}