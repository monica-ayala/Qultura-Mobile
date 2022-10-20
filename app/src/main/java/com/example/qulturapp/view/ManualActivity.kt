package com.example.qulturapp.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide.init
import com.example.qulturapp.R
import com.example.qulturapp.view.museum.ListMuseum
import com.example.qulturapp.view.solicitudes.ActivityHorario
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ManualActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        val solibtn = findViewById<View>(R.id.skipBtn)
        solibtn.setOnClickListener{
            val intent = Intent(this, ListMuseum::class.java)
            startActivity(intent)
        }
    }

    private fun init(){
        val view_pager = findViewById<ViewPager2>(R.id.view_pager)
        val tabDots = findViewById<TabLayout>(R.id.tabs)
        val parent_view = findViewById<RelativeLayout>(R.id.parent_view)
        view_pager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tabDots,view_pager, TabLayoutMediator.TabConfigurationStrategy({tab, position ->

        })).attach()
        view_pager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                //Snackbar.make(parent_view, "You are "+ (position+1),Snackbar.LENGTH_SHORT).show()
            }
        })
    }
}